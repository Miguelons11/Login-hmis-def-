package usuario;

import java.util.List;

public interface IAdministrador {


	public Usuario crearUsuario(String aEmail, String aUsername, String aPassword_, boolean aAdmin, String aFechaCreacion, String aFechaUltimoAcceso);

	public Usuario modificarDatos();

	public Usuario eliminarUsuario(String correo) ;

	public List<Usuario> cargarUsuarios();
}