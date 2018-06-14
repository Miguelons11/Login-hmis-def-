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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Usuario")
public class Usuario implements Serializable {
	public Usuario() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="USUARIO_USUARIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="USUARIO_USUARIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Username", nullable=true, length=255)	
	private String username;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;
	
	@Column(name="Activo", nullable=false, length=1)	
	private boolean activo;
	
	@Column(name="Admin", nullable=false, length=1)	
	private boolean admin;
	
	@Column(name="FechaCreacion", nullable=true, length=255)	
	private String fechaCreacion;
	
	@Column(name="FechaUltimoAcceso", nullable=true, length=255)	
	private String fechaUltimoAcceso;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setActivo(boolean value) {
		this.activo = value;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setAdmin(boolean value) {
		this.admin = value;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	public void setFechaCreacion(String value) {
		this.fechaCreacion = value;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaUltimoAcceso(String value) {
		this.fechaUltimoAcceso = value;
	}
	
	public String getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
