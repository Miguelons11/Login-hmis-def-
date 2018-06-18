package myapplication;

import static org.junit.Assert.*;

import org.junit.Test;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.example.myapplication.Inicio_sesion;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import usuario.BD_Usuario;
import usuario.Usuario;

public class RegistroOk {

	BD_Usuario bd= new BD_Usuario();
	Usuario usr= new Usuario();
	public boolean in;
	String email="pruebaRegistro";
	String name="pruebaRegistro";
	String password="pruebaRegistro";
			

	@Test
	public void registroOkTest() throws PersistentException  {
		registrarUsuario();
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
				.beginTransaction();
		Usuario aux= usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+email+"'",null);
		t.commit(); 
		if(aux!=null) {
			in=true;
			eliminarUsuario();
		}
		assertTrue(in);
	}
	private void registrarUsuario() {
		try {
			bd.registrarse(email, name, password, false, "", "");
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void eliminarUsuario() {
		try {
			bd.eliminarUsuario(email);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
	
