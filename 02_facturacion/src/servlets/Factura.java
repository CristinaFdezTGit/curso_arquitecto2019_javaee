package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Factura
 */
@WebServlet("/Factura")
public class Factura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String producto=request.getParameter("producto");
		double precio= Double.parseDouble(request.getParameter("precio"));
		int unidades=Integer.parseInt(request.getParameter("unidades"));
		int iva = Integer.parseInt(request.getParameter("iva"));
		
		//Suma 100 + 21 = 121.
		//Divide 121 entre 100 = 1,21.
		double ivaFinal=100+iva;
		double resulIva=ivaFinal / 100;
		double totalPrecioProducto=precio * unidades*resulIva;
		
		
		
		out.println("<html>");
		out.println("<body> <center>");
		out.println("<h2> Has comprado "+unidades+" unidades de");
		out.println(" "+producto+" cuyo valor es"+totalPrecioProducto+"</h2>");
		
		out.print("</body> </center>");
		out.print("</html>");
		out.close();
		
		
		
	}

}
