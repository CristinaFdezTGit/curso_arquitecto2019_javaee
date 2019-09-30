package daos;

import java.util.List;

import model.Contacto;

public interface DAOContactos {

	void altaContactos();

	void altaContactos(Contacto contacto);

	void altaContacto(Contacto contacto);

	List<Contacto> listarContactos();

	void eliminarContacto(int idContacto);

}