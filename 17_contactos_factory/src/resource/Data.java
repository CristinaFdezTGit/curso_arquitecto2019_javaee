package resource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Data {
	
	public static DataSource getDataSource(String referencia) {
		//Implementación del PATRON Service Locator
		DataSource ds = null;
		try {
			Context ct = new InitialContext();
			ds= (DataSource) ct.lookup("java:comp/env/refcontactos");
		} catch ( NamingException e) {
			e.printStackTrace();
		}
		
		return ds;
		
	}

}
