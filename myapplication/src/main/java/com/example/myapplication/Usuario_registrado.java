package com.example.myapplication;

import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;


import usuario.Usuario;

public class Usuario_registrado extends Usuario_registrado_ventana implements View {

	public Usuario_registrado() {

		
		botonEditar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println(Inicio_sesion.id);
				UI.getCurrent().getNavigator().navigateTo("editarInformacion");
			}
		});
		botonLogOut.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("");
				Inicio_sesion.id=0;
			}
		});
	}
	

	
}