package com.example.myapplication;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import usuario.IUsuarioNoRegistrado;
import usuario.Usuario;
import usuario.BD_Principal;
import usuario.BD_Usuario;
 
public class Registrarse extends Registrarse_ventana implements View {
	
	IUsuarioNoRegistrado usr = new BD_Principal() ;
	String nombre;
	String correo;
	String contrasena;
	String fecha;
	Calendar c1= Calendar.getInstance();
	int year= c1.get(Calendar.YEAR);
	int month= c1.get(Calendar.MONTH)+1;
	int day= c1.get(Calendar.DAY_OF_MONTH);
	public Registrarse() {
		labelBienvenida.setVisible(true);
		botonEviar.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				
				
				 nombre = nombreText.getValue();
				correo = correoText.getValue();
				contrasena = contrasenaText.getValue();
				fecha=day+"/"+month+"/"+year;
				
				if(contrasena.equals(confirmarContrasenaText.getValue())) {
					try {
						registrarse();
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

	public void registrarse() throws PersistentException {
		PersistentTransaction t = usuario.HMIsPersistentManager.instance().getSession()
				.beginTransaction();
		try {
			
				Usuario aux= usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+correoText.getValue()+"'",null);
				t.commit(); 
				if(aux==null) {
					Usuario usuario= usr.registrarse(correo, nombre, contrasena, false, fecha,fecha);
					Notification.show("Usuario registrado correctamente").setDelayMsec(400);
					Inicio_sesion.id= usuario.getORMID();
					UI.getCurrent().getNavigator().navigateTo("inicioRegistrado");
				}else{
					usuarioYaExiste.setVisible(true);
				}
				
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	
	}

}
