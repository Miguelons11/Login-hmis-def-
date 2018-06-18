package myapplication;

import static org.junit.Assert.*;

import org.junit.Test;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import usuario.BD_Usuario;
import usuario.Usuario;

public class EditarInformacionOk {
	BD_Usuario bd= new BD_Usuario();
	Usuario user= new Usuario();
	public boolean in;

	@Test
	public void editarInformaciontest() throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession().beginTransaction();
		try {
			user= bd.logIn("pruebaTest", "prueba");
			bd.editarInformacion("pruebaHmis", "testEdit", "pruebaHmis");
			Usuario aux = usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='" + "pruebaHmis" + "'", null);
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


