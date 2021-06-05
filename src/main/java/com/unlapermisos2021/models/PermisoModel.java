package com.unlapermisos2021.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PermisoModel {

	private int idPermiso;

	private PersonaModel pedido;

	private LocalDate fecha;

    private Set<LugarModel> lugares = new HashSet<>();

    public PermisoModel () {

	}
	public PermisoModel(int idPermiso) {
		super();
		this.idPermiso=idPermiso;
	}
	
	public PermisoModel(int idPermiso,PersonaModel pedido, Set<LugarModel> lugares, LocalDate fecha) {
		super();
		this.idPermiso=idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
		this.lugares = lugares;
	}

	public PermisoModel(int idPermiso,PersonaModel pedido,LocalDate fecha) {
		super();
		this.idPermiso=idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
	}

	public PermisoModel(int idPermiso,PersonaModel pedido,Set<LugarModel> lugares) {
		super();
		this.idPermiso=idPermiso;
		this.pedido = pedido;
		this.lugares = lugares;
	}
	
	public PermisoModel(PersonaModel pedido,LocalDate fecha) {
		super();
		this.pedido = pedido;
		this.fecha = fecha;
	}
	
	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public PersonaModel getPedido() {
		return pedido;
	}

	public void setPedido(PersonaModel pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<LugarModel> getLugares() {
		return lugares;
	}

	public void setLugares(Set<LugarModel> lugares) {
		this.lugares = lugares;
	}

	public void agregarLugaraPermiso(LugarModel l) {
		lugares.add(l);	
	}
}