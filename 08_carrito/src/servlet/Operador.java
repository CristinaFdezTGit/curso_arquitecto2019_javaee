package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

/**
 * Servlet implementation class Operador
 */
@WebServlet("/Operador")
public class Operador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	    System.out.println("-->entra en el servlet Operador");
	    
	    String comprar= request.getParameter("comprar");
	    System.out.println("-->comprar:"+comprar);
	    String carrito=request.getParameter("carrito");
	    System.out.println("-->carrito:"+carrito);
	    RequestDispatcher rd;
	    HttpSession se=request.getSession();
	    List <Producto> listProductos=(ArrayList<Producto>)se.getAttribute("listProductos");
	    String nombreProducto=request.getParameter("producto");
	    System.out.println("-->nombreProducto:"+nombreProducto);
	    String unidades=request.getParameter("unidades");
	    System.out.println("-->unidades:"+unidades);
	    String precio=request.getParameter("precio");
	    System.out.println("-->precio:"+precio);
	    
	    if(null==unidades) {
	    	unidades="1";
	    	
	    } 
	    if(null==precio) {
	    	precio="1";
	    }
	    Producto producto = new Producto(nombreProducto, Integer.parseInt(unidades),Double.parseDouble(precio));
	    if(null==listProductos) {
	    	listProductos = new ArrayList<Producto>();
	    	//se.setAttribute("listProductos", producto);
	    }
	     listProductos.add(producto);
	    
	    se.setAttribute("listProductos", listProductos);
	    
	    if(null!=comprar) {
	    	rd=request.getRequestDispatcher("comprar.html");
	    	
	    }else{
	    	
	    	rd=request.getRequestDispatcher("vercarrito.jsp");
	    }
	    rd.forward(request, response);
	    	
	}

}
