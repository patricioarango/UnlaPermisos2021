package com.unlapermisos2021.models;

import java.util.List;

import com.unlapermisos2021.entities.Permiso;

public class LugarModel {
	private int idLugar;

	private String nombreLugar;

	private String codigoPostal;

    private List<Permiso> permisos;


    public LugarModel() {	
	}

	public LugarModel(int idLugar,String nombreLugar, String codigoPostal) {
		super();
		this.idLugar=idLugar;
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
