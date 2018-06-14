package com.example.myapplication;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import usuario.BD_Principal;
import usuario.IUsuario;
import usuario.IUsuarioNoRegistrado;
import usuario.Usuario;

public class Editar_informacion extends Editar_informacion_ventana implements View {

	IUsuario usr = new BD_Principal();
	String nombre;
	String correo;
	String contrasena;
	String contrasenaConfirmada;
	public Editar_informacion() {
		botonEviar.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				if (nombreText.isEmpty()) {
					nombre = "";
				} else {
					nombre = nombreText.getValue();
				}

				if (correoText.isEmpty()) {
					correo = "";
				} else {
					correo = correoText.getValue();
				}

				if (contrasenaText.isEmpty()) {
					contrasena = "";
				} else {
					contrasena = contrasenaText.getValue();
				}
				if(confirmarContrasenaText.isEmpty()) {
					contrasenaConfirmada="";
				}else {
					contrasenaConfirmada=confirmarContrasenaText.getValue();
				}

				if (contrasena.equals(confirmarContrasenaText.getValue())) {
					editarInformacion();
				} else {
					passwordNoMatch.setVisible(true);
				}

			}

		});

	}

	private void editarInformacion() {
		Usuario usuario = usr.editarInformacion(correo, nombre, contrasena);
	}
}