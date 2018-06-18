package myapplication;

import static org.junit.Assert.*;

import org.junit.Test;
import org.orm.PersistentException;

import com.example.myapplication.Inicio_sesion;

import usuario.BD_Usuario;
import usuario.Usuario;

public class LogIn {

	BD_Usuario bd= new BD_Usuario();
	Usuario user= new Usuario();
	public boolean in;
	
	@Test
	public void test() throws PersistentException {
		user=bd.logIn("user", "user");
		assertEquals(user.getORMID(),Inicio_sesion.id);
	}

}
