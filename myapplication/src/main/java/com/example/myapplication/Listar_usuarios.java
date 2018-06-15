package com.example.myapplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

import usuario.BD_Principal;
import usuario.IAdministrador;
import usuario.Usuario;

public class Listar_usuarios extends Listar_usuarios_ventana implements View {

	IAdministrador adm=new BD_Principal();
	
	public Listar_usuarios() {
		cargarUsuarios();
		eliminarUsuario.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			   for( Iterator it = listaUsuarios.getValue().iterator(); it.hasNext();) { 
				    String s = (String)it.next();
					adm.eliminarUsuario(s);	
					Notification.show("Usuario eliminado correctamente").setDelayMsec(1000);
					cargarUsuarios();
					
				}
			}
		});
	}
	public void cargarUsuarios() {
	 List<Usuario> lista= adm.cargarUsuarios();
	 List<String> aux = new ArrayList<String>();
	 for(int i=0;i<lista.size();i++) {
		 aux.add(lista.get(i).getEmail());
	 }
		listaUsuarios.setItems(aux);
	}
}
