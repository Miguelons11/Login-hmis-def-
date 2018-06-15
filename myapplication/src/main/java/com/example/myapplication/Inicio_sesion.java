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
	public static int id;
	public static boolean activo=false;

	public Inicio_sesion() {
		botonEnviar.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				nombreUsuario = usuarioText.getValue();
				contrasena = contrasenaText.getValue();
				activo=false;
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
		

		
		if (!usr.getAdmin()) {
			id = usr.getORMID();
			activo=true;

			UI.getCurrent().getNavigator().navigateTo("inicioRegistrado");

		} else {
			
			UI.getCurrent().getNavigator().navigateTo("inicioAdministrador");
		
		}

		

		}catch(NullPointerException n) {
			labelException.setVisible(true);

		}
	
	}

}