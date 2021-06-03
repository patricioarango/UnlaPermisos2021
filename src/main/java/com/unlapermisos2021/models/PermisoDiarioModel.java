package com.unlapermisos2021.models;

import java.time.LocalDate;

import com.unlapermisos2021.entities.Persona;

public class PermisoDiarioModel extends PermisoModel{

	private String motivo;

	public PermisoDiarioModel() {
	
	}

	public PermisoDiarioModel(int idPermiso,Persona pedido, LocalDate fecha, String motivo) {
		super(idPermiso,pedido, fecha);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
