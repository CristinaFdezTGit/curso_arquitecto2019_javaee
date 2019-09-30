package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class EscuchadorSesion
 *
 */
@WebListener
public class EscuchadorSesion implements HttpSessionListener {

   
    public void sessionCreated(HttpSessionEvent se)  { 
    	ServletContext context=	se.getSession().getServletContext();
    	int contador=(Integer)context.getAttribute("cuenta");
		contador++;
		context.setAttribute("cuenta", contador);
    	    	
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
