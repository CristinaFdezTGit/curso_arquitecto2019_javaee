package controller;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DAOContactos;

/**
 * Servlet implementation class EliminiarAction
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintStream stream= new PrintStream(System.out);
		stream.println("--->Entra en EliminiarAction!!");
		int idContacto = Integer.parseInt(request.getParameter("id"));
		new DAOContactos().eliminarContacto(idContacto);
		
		
	}

}
