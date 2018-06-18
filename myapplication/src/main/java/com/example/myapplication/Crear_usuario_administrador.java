package com.example.myapplication;

import java.util.Calendar;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;

import usuario.BD_Principal;
import usuario.IAdministrador;
import usuario.IUsuarioNoRegistrado;
import usuario.Usuario;

public class Crear_usuario_administrador extends Crear_usuario_administrador_ventana implements View {
	IAdministrador admin = new BD_Principal() ;
	String nombre;
	String correo;
	String contrasena;
	String fecha;
	Calendar c1= Calendar.getInstance();
	int year= c1.get(Calendar.YEAR);
	int month= c1.get(Calendar.MONTH);
	int day= c1.get(Calendar.DAY_OF_MONTH);
	boolean adm;
	
	public Crear_usuario_administrador() {

	botonEviar.addClickListener(new Button.ClickListener() {

		@Override
		public void buttonClick(ClickEvent event) {
			
			
			 nombre = nombreText.getValue();
			correo = correoText.getValue();
			contrasena = contrasenaText.getValue();
			fecha=day+"/"+month+"/"+year;
			adm=adminCheck.getValue();
			
			if(contrasena.equals(confirmarContrasenaText.getValue())) {
				try {
					crearUsuario();
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				passwordNoMatch.setVisible(true);
			}

		}
	});
}

public void crearUsuario() throws PersistentException {
	PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
			.beginTransaction();
	try {
		
			Usuario aux= usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+correoText.getValue()+"'",null);
			t.commit(); 
			if(aux==null) {
				Usuario usuario= admin.crearUsuario(correo, nombre, contrasena, adm, fecha,fecha);
				Notification.show("Usuario registrado correctamente").setDelayMsec(1000);
				
			}else{
				usuarioYaExiste.setVisible(true);
			}
			
	} catch (NullPointerException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}

}
}

