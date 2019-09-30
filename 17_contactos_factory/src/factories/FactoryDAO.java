package factories;

import daos.DAOContactos;
import daos.DAOContactosImpl;

public class FactoryDAO {
	
	public static DAOContactos getDaoContactos() {
		return new DAOContactosImpl();
	}

}
