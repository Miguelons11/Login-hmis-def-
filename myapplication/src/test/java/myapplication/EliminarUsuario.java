package myapplication;

import static org.junit.Assert.*;

import org.junit.Test;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.example.myapplication.Inicio_sesion;

import usuario.BD_Usuario;
import usuario.Usuario;

public class EliminarUsuario {
	BD_Usuario bd= new BD_Usuario();
	Usuario user= new Usuario();
	public boolean in;
	String email="pruebaEliminacion";
	String name="pruebaEliminacion";
	String password="pruebaEliminacion";


	@Test
	public void eliminarUsuarioTest() throws PersistentException {
			user =registrarUsuario();
			Inicio_sesion.id= user.getORMID();
			eliminarUsuario();
			PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
					.beginTransaction();
			Usuario aux= usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+email+"'",null);
			t.commit(); 
			if(aux==null) {
				in=true;
				
			}
			assertTrue(in);
		}
		private Usuario registrarUsuario() {
			Usuario us=null;
			try {
				us=bd.registrarse(email, name, password, false, "", "");
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return us;
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