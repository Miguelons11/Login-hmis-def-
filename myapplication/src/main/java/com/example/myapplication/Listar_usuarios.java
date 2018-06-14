package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;

import usuario.BD_Principal;
import usuario.IAdministrador;
import usuario.Usuario;

public class Listar_usuarios extends Listar_usuarios_ventana implements View {

	IAdministrador adm=new BD_Principal();
	List<Usuario> lista=new ArrayList<Usuario>();
	
	public Listar_usuarios() {
		cargarUsuarios();
	}
	public void cargarUsuarios() {
	 lista= adm.cargarUsuarios();
	 List<String> aux = null;
	 for(int i=0;i<=lista.size();i++) {
		 aux.add(lista.get(i).getEmail());
	 }
		listaUsuarios.setItems(aux);
	}
}
