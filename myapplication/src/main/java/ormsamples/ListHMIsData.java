/**
 * Licensee: Miguel(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListHMIsData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Usuario...");
		usuario.Usuario[] usuarioUsuarios = usuario.UsuarioDAO.listUsuarioByQuery(null, null);
		int length = Math.min(usuarioUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(usuarioUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Usuario by Criteria...");
		usuario.UsuarioCriteria lusuarioUsuarioCriteria = new usuario.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lusuarioUsuarioCriteria.ID.eq();
		lusuarioUsuarioCriteria.setMaxResults(ROW_COUNT);
		usuario.Usuario[] usuarioUsuarios = lusuarioUsuarioCriteria.listUsuario();
		int length =usuarioUsuarios== null ? 0 : Math.min(usuarioUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(usuarioUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListHMIsData listHMIsData = new ListHMIsData();
			try {
				listHMIsData.listTestData();
				//listHMIsData.listByCriteria();
			}
			finally {
				usuario.HMIsPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
