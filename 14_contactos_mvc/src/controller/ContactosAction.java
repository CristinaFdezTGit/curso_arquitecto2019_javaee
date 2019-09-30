package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DAOContactos;
import model.Contacto;

/**
 * Servlet implementation class ContactosAction
 */
@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Contacto> listaContacto=new DAOContactos().listarContactos();
		 if(!listaContacto.isEmpty()) {
			 request.setAttribute("resultado", 0);
			 request.setAttribute("contactos", listaContacto);
		 }else {
			 request.setAttribute("resultado", listaContacto.size());
		 }
		 
		 
		 
		 
	}

}
