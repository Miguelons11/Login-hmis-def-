package usuario;

public interface IUsuarioNoRegistrado {

	public Usuario registrarse(String aEmail, String aUsername, String aPassword, boolean aAdmin, String aFechaCreacion, String aFechaUltimoAcceso);
	
}