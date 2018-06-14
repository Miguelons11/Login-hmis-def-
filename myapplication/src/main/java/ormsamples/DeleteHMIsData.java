/**
 * Licensee: Miguel(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteHMIsData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession().beginTransaction();
		try {
			usuario.Usuario lusuarioUsuario = usuario.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			usuario.UsuarioDAO.delete(lusuarioUsuario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteHMIsData deleteHMIsData = new DeleteHMIsData();
			try {
				deleteHMIsData.deleteTestData();
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
