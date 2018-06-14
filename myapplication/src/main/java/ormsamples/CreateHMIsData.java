/**
 * Licensee: Miguel(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateHMIsData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession().beginTransaction();
		try {
			usuario.Usuario lusuarioUsuario = usuario.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : admin, activo
			usuario.UsuarioDAO.save(lusuarioUsuario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateHMIsData createHMIsData = new CreateHMIsData();
			try {
				createHMIsData.createTestData();
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
