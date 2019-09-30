package model;

public class Producto {
	
	String nombreProducto;
	int unidades;
	double precio;
	
	
	public Producto(String nombreProducto, int unidades, double precio) {
		super();
		this.nombreProducto = nombreProducto;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	

}
