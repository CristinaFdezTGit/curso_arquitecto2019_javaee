package controller;

import java.io.IOException;
import java.io.PrintStream;

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
		PrintStream stream= new PrintStream(System.out);
		String urlFinal="entrada.html";
		String operacion=request.getParameter("op");
		stream.println("----> operacion es:"+operacion);
		switch (operacion.trim()) {
		case "doContactos":
			//request.getRequestDispatcher("ContactosAction").include(request, response);	
			urlFinal=obtenerUrl(request,response); //((Integer)request.getAttribute("resultado"))==1? "contactos.jsp":"sincontactos.jsp";
			break;
		case "doAlta":
			request.getRequestDispatcher("AltaAction").include(request, response);
			urlFinal="resultado.html";
			break;
		case "toDatos":
			urlFinal="datos.html";
			break;
		case "toEntrada":
			urlFinal="entrada.html";
			break;
		case "doEliminar":
			request.getRequestDispatcher("EliminarAction").include(request, response);
			//request.getRequestDispatcher("ContactosAction").include(request, response);
			urlFinal= obtenerUrl(request,response);//((Integer)request.getAttribute("resultado"))==1? "contactos.jsp":"sincontactos.jsp";
			break;
		}
		
		stream.println("---->En Controller urlFinal es:"+urlFinal);
		//Transferimos la peticon a la vista
		request.getRequestDispatcher(urlFinal).forward(request, response);
		
		
	}
	
	private String obtenerUrl(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("ContactosAction").include(req, resp);
		return ((Integer)req.getAttribute("resultado"))==1? "contactos.jsp":"sincontactos.jsp";
		
	}

}
