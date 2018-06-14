package usuario;

public interface IUsuario {

	public Usuario logIn(String aUsername, String aPassword) ;

	public void logOut() ;

	public Usuario editarInformacion(String correo, String nombre, String contrasena);
}