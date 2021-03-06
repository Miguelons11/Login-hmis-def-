package usuario;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

public class BD_Principal implements IUsuarioNoRegistrado, IUsuario, IAdministrador {
	public BD_Usuario _bd_usuario=new BD_Usuario(); 
	public Usuario user;
	public Usuario registrarse(String aEmail, String aUsername, String aPassword, boolean aAdmin, String aFechaCreacion, String aFechaUltimoAcceso) {
		try{
			user=_bd_usuario.registrarse(aEmail, aUsername, aPassword, aAdmin, aFechaCreacion, aFechaUltimoAcceso);
			
		}catch(PersistentException e){
			e.printStackTrace();
		}
		return user;
	}

	public Usuario logIn(String aUsername, String aPassword) {
		try {
			user=_bd_usuario.logIn(aUsername, aPassword);
		}
		catch(PersistentException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void modificarDatosPerfil() {
		throw new UnsupportedOperationException();
	}

	public void logOut() {
		throw new UnsupportedOperationException();
	}



	public Usuario crearUsuario(String aEmail, String aUsername, String aPassword_, boolean aAdmin, String aFechaCreacion, String aFechaUltimoAcceso) {
		try{
			user=_bd_usuario.registrarse(aEmail, aUsername, aPassword_, aAdmin, aFechaCreacion, aFechaUltimoAcceso);
			
		}catch(PersistentException e){
			e.printStackTrace();
		}
		return user;
	}
	


	@Override
	public Usuario editarInformacion(String correo, String nombre, String contrasena) {
		try{
			user=_bd_usuario.editarInformacion(correo, nombre, contrasena);
			
		}catch(PersistentException e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Usuario> cargarUsuarios() {
		List<Usuario> lista=new ArrayList<Usuario>();

		try {
			 lista= _bd_usuario.cargarUsuarios();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Usuario eliminarUsuario(String correo) {

		try{
			Usuario user=_bd_usuario.eliminarUsuario(correo);
		}catch(PersistentException e) {
			e.printStackTrace();
		}
		return user;
	}
	}
