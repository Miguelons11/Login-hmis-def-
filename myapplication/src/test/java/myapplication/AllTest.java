package myapplication;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EditarInformacionOk.class, LogIn.class, RegistroOk.class, EliminarUsuario.class })
public class AllTest {

}
