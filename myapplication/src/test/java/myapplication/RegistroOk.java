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
	Usuario user= new Usuario();
	public boolean in;

	@Test
	public void registroOkTest() throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession().beginTransaction();
		try {
			user = bd.registrarse("pruebatest", "prueba", "prueba", false, "", "");
			Usuario aux = usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='" + "pruebatest" + "'", null);
			t.commit();
			if (aux == null) {
				in=false;
			} else {
				in=true;
			}

		} catch (PersistentException e) {
			t.rollback();
		}
		assertTrue(in);
	}
}
		
	
