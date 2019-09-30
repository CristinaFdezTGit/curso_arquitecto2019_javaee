package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Persona;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		
		if(user.equals("admin")&&pwd.equals("admin")) {
		
			Persona person= new Persona("Pepe", "pepito@ticgetafe.com", 32);
			person.setUsuario(user);
			request.setAttribute("persona", person);
			System.out.println("--> se va ir a pagina de Bienvenida");
			rd=request.getRequestDispatcher("Bienvenida");
		}else {
			rd=request.getRequestDispatcher("Error");
			
			//response.sendRedirect("Error?user="+user+"&pwd="+pwd);
			//response.sendRedirect("http://www.google.com");
			
		}
		rd.forward(request, response);
		
	}

	
}
