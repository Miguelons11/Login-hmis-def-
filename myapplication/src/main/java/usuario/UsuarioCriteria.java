/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Miguel(University of Almeria)
 * License Type: Academic
 */
package usuario;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UsuarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression username;
	public final StringExpression password;
	public final BooleanExpression activo;
	public final BooleanExpression admin;
	public final StringExpression fechaCreacion;
	public final StringExpression fechaUltimoAcceso;
	
	public UsuarioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		email = new StringExpression("email", this);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		activo = new BooleanExpression("activo", this);
		admin = new BooleanExpression("admin", this);
		fechaCreacion = new StringExpression("fechaCreacion", this);
		fechaUltimoAcceso = new StringExpression("fechaUltimoAcceso", this);
	}
	
	public UsuarioCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario.class));
	}
	
	public UsuarioCriteria() throws PersistentException {
		this(HMIsPersistentManager.instance().getSession());
	}
	
	public Usuario uniqueUsuario() {
		return (Usuario) super.uniqueResult();
	}
	
	public Usuario[] listUsuario() {
		java.util.List list = super.list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}

