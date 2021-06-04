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
@Table(name="rodado")
public class Rodado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRodado;

	@Column(name="dominio")
	private String dominio;

	@Column(name="vehiculo")
	private String vehiculo;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="rodado")
	private Set<PermisoPeriodo> permisoPeriodos = new HashSet<PermisoPeriodo>();


	public Rodado() {
	}

	public Rodado(int idRodado,String dominio, String vehiculo) {
		super();
		this.idRodado=idRodado;
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Set<PermisoPeriodo> getPermisoPeriodos() {
		return permisoPeriodos;
	}

	public void setPermisoPeriodos(Set<PermisoPeriodo> permisoPeriodos) {
		this.permisoPeriodos = permisoPeriodos;
	}

}
