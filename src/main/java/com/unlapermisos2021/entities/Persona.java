package com.unlapermisos2021.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;

	@Column(name="nombrePersona")
	private String nombrePersona;

	@Column(name="apellidoPersona")
	private String apellidoPersona ;

	@Column(name="dniPersona")
	private long dniPersona ;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
	private Set<Permiso> permisos = new HashSet<Permiso>();

	public Persona() {
	}


	public Persona(String nombrePersona, String apellidoPersona, long dniPersona) {
		super();
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


}
