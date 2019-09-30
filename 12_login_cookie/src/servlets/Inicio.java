package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Persona;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie [] cookies=request.getCookies();
		RequestDispatcher rd= request.getRequestDispatcher("formulario.html");
		System.out.println("--> cookies es:"+cookies);
		if(null!=cookies) {
			for(Cookie ck:cookies){
				if(ck.getName().equals("usuario")){
					String valor=ck.getValue();
					Persona persona=new Persona(valor,"prueba@gmail.com",44);
					HttpSession sesion=request.getSession();
					sesion.setAttribute("persona", persona);
					
					rd=request.getRequestDispatcher("preferencias.html");
				}
			}
		}
		
		rd.forward(request, response);
			
		
		
	}
	

	

}
