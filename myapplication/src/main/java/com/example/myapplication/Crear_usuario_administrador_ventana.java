package com.example.myapplication;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Crear_usuario_administrador_ventana extends VerticalLayout {
	protected TextField nombreText;
	protected TextField correoText;
	protected PasswordField contrasenaText;
	protected PasswordField confirmarContrasenaText;
	protected Label usuarioYaExiste;
	protected Label passwordNoMatch;
	protected CheckBox adminCheck;
	protected Button botonEviar;

	public Crear_usuario_administrador_ventana() {
		Design.read(this);
	}
}
