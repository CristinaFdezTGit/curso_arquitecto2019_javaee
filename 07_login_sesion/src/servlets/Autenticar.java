package servlets;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		PrintStream stream = new PrintStream(System.out);
		
		if(user.equals("admin")&&pwd.equals("admin")) {
		
			Persona person= new Persona("Pepe", "pepito@ticgetafe.com", 32);
			person.setUsuario(user);
			
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("persona", person);
		
			stream.println("--> se va a preferencias.html");
			rd=request.getRequestDispatcher("preferencias.html");
			rd.forward(request, response);
			
			
		}else {
			//rd=request.getRequestDispatcher("error.jsp");
			
			response.sendRedirect("error.jsp?user="+user+"&pwd="+pwd);
			//response.sendRedirect("http://www.google.com");
			
		}
		//rd.forward(request, response);
		
	}

	
}
