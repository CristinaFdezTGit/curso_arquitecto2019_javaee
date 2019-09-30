package filtros;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter("/*")
public class FiltroLogin implements Filter {

   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintStream stream = new PrintStream(System.out);
		//Se recupera la direccion original solicitada y si quiere autenticarse le dejamos pasar
		stream.println("--->getContextPath:"+((HttpServletRequest)request).getContextPath());
		String path=((HttpServletRequest)request).getServletPath();
		stream.println("--->getServletPath:"+path);
		if(path.equals("/") || path.equals("/Autenticar")) {
			chain.doFilter(request, response);
		}
		
		/*Comprobamos la existencia del atributo de sesion "persona"
		Sí no exite, le mandamos a Inicio
		*/
		stream.println("--->continuamos!!");
		HttpSession sesion=((HttpServletRequest)request).getSession();
		stream.println("-->sesion.getAttribute(\"persona\"):"+sesion.getAttribute("persona"));
		if(sesion.getAttribute("persona")!=null) {
			chain.doFilter(request, response);
		}else {
			request.getRequestDispatcher("Inicio").forward(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
