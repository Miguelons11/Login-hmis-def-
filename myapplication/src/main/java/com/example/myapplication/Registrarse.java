package com.example.myapplication;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import com.vaadin.ui.Image;

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
	Calendar c1= new GregorianCalendar();
	public Registrarse() {
		labelBienvenida.setVisible(true);
		botonEviar.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				
				
				 nombre = nombreText.getValue();
				correo = correoText.getValue();
				contrasena = contrasenaText.getValue();
				fecha=c1.DAY_OF_MONTH+"/"+c1.MONTH+"/"+c1.YEAR;
				
				if(contrasena.equals(confirmarContrasenaText.getValue())) {
					registrarse();
				}else {
					passwordNoMatch.setVisible(true);
				}

			}
		});
	}

	public void registrarse() {
		try {
				Usuario aux= usuario.UsuarioDAO.loadUsuarioByQuery("Usuario.email='"+correoText.getValue()+"'",null);
				usuarioYaExiste.setVisible(true);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			Usuario usuario= usr.registrarse(correo, nombre, contrasena, false, fecha,fecha);

		}
	
	}

}
