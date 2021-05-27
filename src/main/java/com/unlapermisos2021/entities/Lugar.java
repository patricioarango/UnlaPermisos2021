package com.unlapermisos2021.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="lugar")
public class Lugar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLugar;
	
	@Column(name="nombrelugar")
	private String nombreLugar;
	
	@Column(name="codigopostal")
	private String codigoPostal;
	
	@ManyToMany(mappedBy = "lugares")
	private List<Permiso> permisos;

	public Lugar() {	
	}

	public Lugar(String nombreLugar, String codigoPostal) {
		super();
		this.nombreLugar = nombreLugar;
		this.codigoPostal = codigoPostal;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getNombreLugar() {
		return nombreLugar;
	}

	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	
	
}

