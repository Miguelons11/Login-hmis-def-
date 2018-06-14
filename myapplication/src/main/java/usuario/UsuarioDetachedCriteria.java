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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UsuarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression email;
	public final StringExpression username;
	public final StringExpression password;
	public final BooleanExpression activo;
	public final BooleanExpression admin;
	public final StringExpression fechaCreacion;
	public final StringExpression fechaUltimoAcceso;
	
	public UsuarioDetachedCriteria() {
		super(usuario.Usuario.class, usuario.UsuarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		activo = new BooleanExpression("activo", this.getDetachedCriteria());
		admin = new BooleanExpression("admin", this.getDetachedCriteria());
		fechaCreacion = new StringExpression("fechaCreacion", this.getDetachedCriteria());
		fechaUltimoAcceso = new StringExpression("fechaUltimoAcceso", this.getDetachedCriteria());
	}
	
	public UsuarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, usuario.UsuarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		activo = new BooleanExpression("activo", this.getDetachedCriteria());
		admin = new BooleanExpression("admin", this.getDetachedCriteria());
		fechaCreacion = new StringExpression("fechaCreacion", this.getDetachedCriteria());
		fechaUltimoAcceso = new StringExpression("fechaUltimoAcceso", this.getDetachedCriteria());
	}
	
	public Usuario uniqueUsuario(PersistentSession session) {
		return (Usuario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Usuario[] listUsuario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}

