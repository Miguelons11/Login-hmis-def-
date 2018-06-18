package myapplication;

import static org.junit.Assert.*;

import org.junit.Test;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.example.myapplication.Inicio_sesion;

import usuario.BD_Principal;
import usuario.BD_Usuario;
import usuario.IUsuario;
import usuario.IUsuarioNoRegistrado;
import usuario.Usuario;

public class EditarInformacionOk {
	BD_Usuario bd= new BD_Usuario();
	Usuario user= new Usuario();
	public boolean in;
	String email="pruebaInformacion";
	String name="pruebaInformacion";
	String password="pruebaInformacion";
	String nuevoEmail="cambiado";
	String nuevoName="cambiado";
	String nuevoPass="cambiado";

	@Test
	public void editarInformaciontest() throws PersistentException {
			user =registrarUsuario();
			Inicio_sesion.id= user.getORMID();

			editarInformacion();
			PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
					.beginTransaction();
			Usuario aux= usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+nuevoEmail+"'",null);
			t.commit(); 
			if(aux!=null) {
				in=true;
				eliminarUsuario();
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
				bd.eliminarUsuario(nuevoEmail);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void editarInformacion() {
			try {
				bd.editarInformacion(nuevoEmail, nuevoName, nuevoPass);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	


