package com.unlapermisos2021.models;

import java.time.LocalDate;
import java.util.List;

import com.unlapermisos2021.entities.Persona;
import com.unlapermisos2021.entities.Lugar;

public class PermisoModel {

	private int idPermiso;
	
	private Persona pedido;
	
	private LocalDate fecha ;
	
    private List<Lugar> lugares;
    
    public PermisoModel () {
		
	}

	public PermisoModel(int idPermiso,Persona pedido, LocalDate fecha) {
		super();
		this.idPermiso=idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Persona getPedido() {
		return pedido;
	}

	public void setPedido(Persona pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Lugar> getLugares() {
		return lugares;
	}

	public void setLugares(List<Lugar> lugares) {
		this.lugares = lugares;
	}
	

}
