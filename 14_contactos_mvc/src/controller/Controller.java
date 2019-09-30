package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String urlFinal="entrada.html";
		String operacion=request.getParameter("op");
		switch (operacion) {
		case "doContactos":
			request.getRequestDispatcher("ContactosAction").include(request, response);	
			urlFinal= ((Integer)request.getAttribute("resultado"))==1? "contactos.jsp":"sincontactos.jsp";
			break;
		case "doAlta":
			request.getRequestDispatcher("AltaAction").include(request, response);
			break;
		case "toDatos":
			urlFinal="entrada.html";
			break;
		case "toEntrada":
			urlFinal="entrada.html";
			break;
		default:
			urlFinal="entrada.html";
			break;
		}
		
		//Transferimos la peticon a la vista
		request.getRequestDispatcher(urlFinal).forward(request, response);
		
		
	}

}
