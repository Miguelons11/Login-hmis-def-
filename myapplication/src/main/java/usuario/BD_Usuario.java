package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.example.myapplication.Inicio_sesion;

import usuario.Usuario;

public class BD_Usuario {
	public Vector<Usuario> _contiene_usuario = new Vector<Usuario>();
	public BD_Principal _bd_prin_usuario;
	byte numero=0;

	public Usuario crearUsuario(String aEmail, String aUsername, String aPassword_, boolean aAdmin, String aFechaCreacion, String aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public Usuario eliminarUsuario(String correo) throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
				.beginTransaction();
		
		try {
			Usuario usr = usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+correo+"'",null);
			usuario.UsuarioDAO.delete(usr);
			t.commit();
			return usr;
			
		} catch (PersistentException e) {
			t.rollback();

		}
		return null;
	}

	
	public Usuario logIn(String aUsername, String aPassword) throws PersistentException{
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
				.beginTransaction();
		
		try {
			Usuario usr = usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+aUsername+"'",null);
			t.commit();
			return usr;
			
		} catch (PersistentException e) {
			t.rollback();

		}
		return null;
	}

	public void logOut() {
		throw new UnsupportedOperationException();
	}

	public Usuario modificarDatos() {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosPerfil() {
		throw new UnsupportedOperationException();
	}

	public Usuario registrarse(String aEmail, String aUsername, String aPassword, boolean aAdmin, String aFechaCreacion, String aFechaUltimoAcceso) throws PersistentException {
		int idUsuario = -1;
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
				.beginTransaction();
		Usuario usr=new Usuario();;
		try {
			usr = usuario.UsuarioDAO.createUsuario();
			usr.setEmail(aEmail);
			usr.setUsername(aUsername);
			usr.setPassword(aPassword);
			usr.setAdmin(aAdmin);
			usr.setFechaCreacion(aFechaCreacion);
			usr.setFechaUltimoAcceso(aFechaUltimoAcceso);
			usuario.UsuarioDAO.save(usr);
			idUsuario = usr.getORMID();
			t.commit();

		} catch (Exception e) {
			t.rollback();
		}
		return usr;
	}

	public Usuario editarInformacion(String correo, String nombre, String contrasena) throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
				.beginTransaction();
		Usuario usr=new Usuario();;
		try {
			usr = usuario.UsuarioDAO.loadUsuarioByORMID(Inicio_sesion.id);
			if(correo!="")
				usr.setEmail(correo);
			if(nombre!="")
			usr.setUsername(nombre);
			if(contrasena!="")
			usr.setPassword(contrasena);
			
			usuario.UsuarioDAO.save(usr);
			t.commit();

		} catch (Exception e) {
			t.rollback();
		}
		return usr;
	}

	
	public List<Usuario> cargarUsuarios() throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
				.beginTransaction();
		List<Usuario> lista=new ArrayList<Usuario>();
		Usuario[] aux;
		try {
			aux= usuario.UsuarioDAO.listUsuarioByQuery("Usuario.admin='"+ 0 +"'", null);
			for(int i=0;i<=aux.length;i++) {
				lista.add(aux[i]);
			}
			t.commit();
		}catch(Exception e) {
		t.rollback();
		}
		return lista;
	}
}