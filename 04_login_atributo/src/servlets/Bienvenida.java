package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Persona;

/**
 * Servlet implementation class Bienvenida
 */
@WebServlet("/Bienvenida")
public class Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //tipo de formato de respuesta
		PrintWriter out=response.getWriter(); //construimos página de respuesta
		
		System.out.println("---> En Bienvenida");
		out.println("<html><body>");
		
		Persona persona = (Persona) request.getAttribute("persona");
		
		out.println("<h1>Bienvenido "+persona.getNombre()+" a mi página</h1>");
		out.println("<br/>");
		out.println("<h2>usuario: "+persona.getUsuario()+" </h2>");
		out.println("<h2>email: "+persona.getEmail()+" </h2>");
		out.println("<h2>edad: "+persona.getEdad()+" </h2>");
		out.println("<br/>");
		out.println("<br/>");
		out.println("<a href='formulario.html'>volver</a>");
		out.println("</body></html>");
	}

}
