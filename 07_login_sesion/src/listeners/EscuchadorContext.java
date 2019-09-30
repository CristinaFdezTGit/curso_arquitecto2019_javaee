package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Contador
 *
 */
@WebListener
public class EscuchadorContext implements ServletContextListener {


	
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context=sce.getServletContext();
//		int contador=0;
//		if(context.getAttribute("cuenta")!=null) {
//			contador=(Integer)context.getAttribute("cuenta");
//		}
//		contador++;
//		context.setAttribute("cuenta", contador);
		
		context.setAttribute("cuenta",0);
		
		
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
        // TODO Auto-generated method stub
   }
	
}
