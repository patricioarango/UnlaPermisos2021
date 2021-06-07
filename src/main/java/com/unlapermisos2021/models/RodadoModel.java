package com.unlapermisos2021.models;

import java.util.HashSet;
import java.util.Set;

import com.unlapermisos2021.entities.PermisoPeriodo;

public class RodadoModel {

	private int idRodado;

	private String dominio;

	private String vehiculo;

	private Set<PermisoPeriodo> permisoPeriodos = new HashSet<PermisoPeriodo>();	

	public RodadoModel() {
	}

	public RodadoModel(int idRodado,String dominio, String vehiculo) {
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

	@Override
	public String toString() {
		return "[idRodado: "+ this.idRodado + ", dominio: " + this.getDominio() + " , vehiculo: " + this.getVehiculo() + "]";
	}
}