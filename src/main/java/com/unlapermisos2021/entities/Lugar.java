package com.unlapermisos2021.entities;
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
@Table(name = "lugar")
public class Lugar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLugar;

	@Column(name="lugar")
	private String lugar;

	@Column(name="codigopostal")
	private String codigoPostal;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="desde")
	private Set<Permiso> setdesde;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="hasta")
	private Set<Permiso> sethasta;
	
	public Lugar() {	
	}

	public Lugar(String lugar, String codigoPostal) {
		super();
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}
	
	public Lugar(int idLugar,String lugar, String codigoPostal) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}
	
	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Set<Permiso> getDesde() {
		return setdesde;
	}

	public Set<Permiso> getHasta() {
		return sethasta;
	}
	
	public void setSetdesde(Set<Permiso> setdesde) {
		this.setdesde = setdesde;
	}

	public void setSethasta(Set<Permiso> sethasta) {
		this.sethasta = sethasta;
	}
}
