package com.example.myapplication;

import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;


import usuario.Usuario;

public class Usuario_registrado extends Usuario_registrado_ventana implements View {

	public Usuario_registrado() {
		if(Inicio_sesion.activo==true) {
			try {
				
				Usuario usr = usuario.UsuarioDAO.getUsuarioByORMID(Inicio_sesion.id) ;
				nombreText.setValue(usr.getUsername());
			
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		botonEditar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("editarInformacion");
			}
		});
		botonLogOut.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("");
				//FALTA ESTABLECER EL ID DE INICIO DE SESIONA -1 
				//CUANDO PODAMOS CONTROLAR EL CONSTRUCTOR
			}
		});
	}
	
	public Usuario_registrado(String n) {
		botonEditar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("editarInformacion");
			}
		});
		botonLogOut.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("");
				//FALTA ESTABLECER EL ID DE INICIO DE SESIONA -1 
				//CUANDO PODAMOS CONTROLAR EL CONSTRUCTOR
			}
		});
	}


	
}