package com.unlapermisos2021.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username", unique = true, nullable = false, length = 15)
	private String username;

	@Column(name = "password", nullable = false, length = 8)
	private String password;

	@Column(name = "email", nullable = false, length = 50)
	private String email;


	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 50)
	private String apellido;
	
	@Column(name = "tipo_documento", nullable = false, length = 50)
	private String tipo_documento;

	@Column(name = "nro_documento", nullable = false, length = 50)
	private String nro_documento;
	
	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDateTime createdat;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedat;
	
	@ManyToOne
	@JoinColumn(name="id_rol")
	private UserRole rol;

	public Usuario() {
	}

	public Usuario(String nombre, String apellido, String email, String username, String password, String tipo_documento, String nro_documento,UserRole rol) {
		this.setApellido(apellido);
		this.setEmail(email);
		this.setNombre(nombre);
		this.setEnabled(true);
		this.setPassword(password);
		this.setRol(rol);
		this.setNro_documento(nro_documento);
		this.setTipo_documento(tipo_documento);
		this.setCreatedAt(LocalDateTime.now());
		this.setUpdatedAt(LocalDateTime.now());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreatedAt() {
		return createdat;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdat = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedat;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedat = updatedAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public UserRole getRol() {
		return rol;
	}

	public void setRol(UserRole rol) {
		this.rol = rol;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getNro_documento() {
		return nro_documento;
	}
	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}
}