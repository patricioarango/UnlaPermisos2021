package com.unlapermisos2021.models;

import java.util.HashSet;
import java.util.Set;

import com.unlapermisos2021.entities.Permiso;
import com.unlapermisos2021.entities.Usuario;

public class PersonaModel {
	private int idPersona;

	private String nombrePersona;
	
	private String apellidoPersona ;
	
	private String nombreUsuarioPersona;
	
	private long dniPersona ;
	
	private Set<Permiso> permisos = new HashSet<Permiso>();
	
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	public PersonaModel() {
	}

	public PersonaModel(int idPersona,String nombrePersona, String apellidoPersona, long dniPersona,String nombreUsuarioPersona) {
		this.idPersona=idPersona;
		this.nombrePersona = nombrePersona;
		this.apellidoPersona = apellidoPersona;
		this.dniPersona = dniPersona;
		this.nombreUsuarioPersona= nombreUsuarioPersona;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public String getNombreUsuarioPersona() {
		return nombreUsuarioPersona;
	}

	public void setNombreUsuarioPersona(String nombreUsuarioPersona) {
		this.nombreUsuarioPersona = nombreUsuarioPersona;
	}

	public long getDniPersona() {
		return dniPersona;
	}

	public void setDniPersona(long dniPersona) {
		this.dniPersona = dniPersona;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
}
