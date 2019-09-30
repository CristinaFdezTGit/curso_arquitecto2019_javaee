package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Contacto;
import resource.Data;



public class DAOContactosImpl implements DAOContactos {
	
	static DataSource ds;
	
	//Bloque estatico que se crea y se inicializa una sola vez
	static {
		//Pasamos la referencia de la BD
		//PATRON Service Locator
		ds=Data.getDataSource("refcontactos");
	}
	
	//////////////////////////////////////////
	//Este seria el bloque de inicio de una clase solo las llaves ==>{}
	//Se ejcutaria siempre lo primero cuando se llame a la clase  
	{
		
	}
	
	/////////////////////////////////////////
	// Implementamos los métodos
	
	@Override
	public void altaContactos() {
		
		try (Connection con = ds.getConnection();){
			String sql= "INSERT INTO contactos (nombre,email,edad) VALUES("+
					" 'jdbc','jdbc@gmail.com',50 )";
			Statement st = con.createStatement();
			st.execute(sql);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void altaContactos(Contacto contacto) {
		altaContacto(contacto);
//		try (Connection con = DriverManager.getConnection(URL, USER, PASS)){
//			String sql= "INSERT INTO contactos (nombre,email,edad) VALUES("+
//					" '"+contacto.getNombre()+"', '"+contacto.getEmail()+"', "+contacto.getEdad()+")";
//			Statement st = con.createStatement();
//			st.execute(sql);
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	@Override
	public void altaContacto(Contacto contacto) {
		String sql= "INSERT INTO contactos (nombre,email,edad) VALUES(?,?,?)";
		try(Connection con =  ds.getConnection();) {
			
			PreparedStatement ps= con.prepareStatement(sql);
		
			ps.setString(1,contacto.getNombre());
			ps.setString(2,contacto.getEmail());
			ps.setInt(3,contacto.getEdad());
			//ejecutamos
			ps.execute();
			
		} catch (SQLException e) {
			System.err.println("--->>ERROR en insertar: "+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public List<Contacto> listarContactos() {
		 String sql="SELECT * FROM contactos";
		 List <Contacto> listaContac= new ArrayList<Contacto>();
		try(Connection con =  ds.getConnection();) {
			PreparedStatement ps= con.prepareStatement(sql);
			 ResultSet rs =ps.executeQuery(sql);  
			 while(rs.next()){
				 Contacto contac= new Contacto(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getInt(4));
				 listaContac.add(contac);
			 }   
			
		} catch (SQLException e) {
			System.err.println("--->>ERROR en listarContactos: "+e.getMessage());
			e.printStackTrace();
		}
		
		return listaContac;
		
	}
	
	@Override
	public void eliminarContacto(int idContacto) {
		String sql="DELETE FROM contactos WHERE idContacto = ?";
		 
		try(Connection con =  ds.getConnection();) {
			
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, idContacto);
			ps.execute();
			
	 
		} catch (SQLException e) {
			System.err.println("--->>ERROR en eliminarContacto: "+e.getMessage());
			e.printStackTrace();
		}
	
	}

}
