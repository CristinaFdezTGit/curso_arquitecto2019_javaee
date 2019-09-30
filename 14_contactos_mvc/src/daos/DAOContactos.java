package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;



public class DAOContactos {
	private static final String URL="jdbc:mysql://localhost:3306/agenda";
	private static final String USER="root";
	private static final String PASS="root";
	
	//Bloque estatico que se crea y se inicializa una sola vez
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/////////////////////////////////////////
	// Implementamos los métodos
	
	public void altaContactos() {
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS)){
			String sql= "INSERT INTO contactos (nombre,email,edad) VALUES("+
					" 'jdbc','jdbc@gmail.com',50 )";
			Statement st = con.createStatement();
			st.execute(sql);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
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
	
	public void altaContacto(Contacto contacto) {
		String sql= "INSERT INTO contactos (nombre,email,edad) VALUES(?,?,?)";
		try(Connection con = DriverManager.getConnection(URL, USER, PASS);) {
			
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
	
	public List<Contacto> listarContactos() {
		 String sql="SELECT * FROM contactos";
		 List <Contacto> listaContac= new ArrayList<Contacto>();
		try(Connection con = DriverManager.getConnection(URL, USER, PASS);) {
			PreparedStatement ps= con.prepareStatement(sql);
			 ResultSet rs =ps.executeQuery(sql);  
			 while(rs.next()){
				 Contacto contac= new Contacto( rs.getString(2),  rs.getString(3),  rs.getInt(4));
				 listaContac.add(contac);
			 }   
			
		} catch (SQLException e) {
			System.err.println("--->>ERROR en listarContactos: "+e.getMessage());
			e.printStackTrace();
		}
		
		return listaContac;
		
	}
	

}
