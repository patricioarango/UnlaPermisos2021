package com.unlapermisos2021.models;

import java.time.LocalDateTime;

import com.unlapermisos2021.entities.Tipo_documento;

public class UsuarioModel {
	private long id;
	private String apellido;
	private String nombre;
	private String username;
	private String password;
	private String email;
	private UserRoleModel rol;
	private Tipo_documento tipo_documento;
	private String nro_documento;
	private LocalDateTime createdat;
	private LocalDateTime updatedad;
	private boolean enabled;
	
	public UsuarioModel() {}
	
	public UsuarioModel(long Id, String nombre, String apellido, String email, String username,String password,Tipo_documento tipo_documento, String nro_documento, UserRoleModel rol,boolean enabled) {
		this.setId(Id);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setNombre(nombre);
		this.setEnabled(enabled);
		this.setPassword(password);
		this.setUsername(username);
		this.setRol(rol);
		this.setNro_documento(nro_documento);
		this.setTipo_documento(tipo_documento);
		this.setCreatedat(LocalDateTime.now());
		this.setUpdatedad(LocalDateTime.now());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRoleModel getRol() {
		return rol;
	}
	public void setRol(UserRoleModel rol) {
		this.rol = rol;
	}
	public Tipo_documento getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(Tipo_documento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getNro_documento() {
		return nro_documento;
	}
	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}
	public LocalDateTime getCreatedat() {
		return createdat;
	}
	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}
	public LocalDateTime getUpdatedad() {
		return updatedad;
	}
	public void setUpdatedad(LocalDateTime updatedad) {
		this.updatedad = updatedad;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "\napellido: " + apellido + "\nnombre: " + nombre + "\ndni: " + nro_documento + "\nenabled: " + enabled
				+"\nusername: " + username +  "\npassword: " + password;
	}
}