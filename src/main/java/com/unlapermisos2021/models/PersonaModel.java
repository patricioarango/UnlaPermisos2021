package com.unlapermisos2021.models;

import java.util.HashSet;
import java.util.Set;

import com.unlapermisos2021.entities.Permiso;

public class PersonaModel {
	private int idPersona;

	private String nombrePersona;

	private String apellidoPersona ;

	private long dniPersona ;

	private Set<Permiso> permisos = new HashSet<Permiso>();

	public PersonaModel() {
	}

	public PersonaModel(int idPersona,String nombrePersona, String apellidoPersona, long dniPersona) {
		this.idPersona=idPersona;
		this.nombrePersona = nombrePersona;
		this.apellidoPersona = apellidoPersona;
		this.dniPersona = dniPersona;
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

	@Override
	public String toString() {
		return "[nombre: " + this.getNombrePersona() + " dni: " + this.getDniPersona() + "]";
	}

	
}