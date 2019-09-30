package controller;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DAOContactos;
import factories.FactoryDAO;
import model.Contacto;

/**
 * Servlet implementation class Alta
 * con urlPatterns se pueden meter varios nombres al servlet
 */
@WebServlet(urlPatterns = {"/AltaAction"})
public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintStream stream = new PrintStream(System.out);
		String nombre= request.getParameter("nombre");
		
		stream.println("-->nombre:"+nombre);
		
		if(null!=nombre){
			stream.println("-->va a insertar datos");
			String email=request.getParameter("email");
			int edad = Integer.parseInt(request.getParameter("edad"));
			
			Contacto contacto = new Contacto(nombre, email, edad);
			
			FactoryDAO.getDaoContactos().altaContacto(contacto);
			
			
		
		}
		else {
			DAOContactos dao= FactoryDAO.getDaoContactos();
			dao.altaContactos();
			
		}
		
		
		
	}

}
