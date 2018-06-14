/**
 * Licensee: Miguel(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateHMIsData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession().beginTransaction();
		try {
			usuario.Usuario lusuarioUsuario = usuario.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			usuario.UsuarioDAO.save(lusuarioUsuario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		usuario.UsuarioCriteria lusuarioUsuarioCriteria = new usuario.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lusuarioUsuarioCriteria.ID.eq();
		System.out.println(lusuarioUsuarioCriteria.uniqueUsuario());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateHMIsData retrieveAndUpdateHMIsData = new RetrieveAndUpdateHMIsData();
			try {
				retrieveAndUpdateHMIsData.retrieveAndUpdateTestData();
				//retrieveAndUpdateHMIsData.retrieveByCriteria();
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
