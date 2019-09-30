package factories;

import daos.DAOContactos;
import daos.DAOContactosImpl;

//Clase de factoria
public class FactoryDAO {
	
	public static DAOContactos getDaoContactos() {
		return new DAOContactosImpl();
	}

}
