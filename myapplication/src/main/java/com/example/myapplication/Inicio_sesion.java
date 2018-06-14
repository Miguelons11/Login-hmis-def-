package com.example.myapplication;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;

import usuario.BD_Principal;
import usuario.Usuario;

public class Inicio_sesion extends Inicio_sesion_ventana implements View {

	usuario.IUsuario usuario = new BD_Principal();;

	String nombreUsuario;
	String contrasena;
	public static int id=1;
	public static boolean activo;

	public Inicio_sesion() {
		botonEnviar.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				nombreUsuario = usuarioText.getValue();
				contrasena = contrasenaText.getValue();
				iniciarSesion();
			}
		});
	
		botonRegistro.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
			UI.getCurrent().getNavigator().navigateTo("registrarse");
			}
		});
	}

	public void iniciarSesion() {

		
		try {
		Usuario usr = usuario.logIn(nombreUsuario, contrasena);
		
		activo=true;

		
		
		if (usr.getAdmin() == false) {

			UI.getCurrent().getNavigator().navigateTo("inicioRegistrado");

		} else {
			
			UI.getCurrent().getNavigator().navigateTo("inicioAdministrador");
		
		}

		id = usr.getORMID();
		
		}catch(NullPointerException n) {
			labelException.setVisible(true);

		}
	
	}

}