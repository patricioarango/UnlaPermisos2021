package com.unlapermisos2021.models;

import java.util.List;

import com.unlapermisos2021.entities.Permiso;

public class LugarModel {
	private int idLugar;

	private String lugar;

	private String codigoPostal;

    private List<Permiso> permisos;


    public LugarModel() {	
	}

	public LugarModel(int idLugar,String lugar, String codigoPostal) {
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

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	@Override
	public String toString() {
		return "[idLugar: "+ this.idLugar + ", lugar: " + this.getLugar() + " , codigoPostal: " + this.getCodigoPostal() + "]";
	}

}
