package com.unlapermisos2021.models;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PermisoModel {

	private int idPermiso;

	private PersonaModel pedido;
	
	private LocalDate fecha;
	private LugarModel desde;
    private LugarModel hasta;

    public PermisoModel () {

	}
	public PermisoModel(int idPermiso) {
		super();
		this.idPermiso=idPermiso;
	}

	public PermisoModel(int idPermiso,PersonaModel pedido, LugarModel desde, LugarModel hasta, LocalDate fecha) {
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
		this.desde = desde;
		this.hasta = hasta;
	}
	
	public PermisoModel(PersonaModel pedido, LugarModel desde, LugarModel hasta, LocalDate fecha) {
		this.pedido = pedido;
		this.fecha = fecha;
		this.desde = desde;
		this.hasta = hasta;
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
    public LugarModel getDesde() {
		return desde;
	}
	public void setDesde(LugarModel desde) {
		this.desde = desde;
	}
	public LugarModel getHasta() {
		return hasta;
	}
	public void setHasta(LugarModel hasta) {
		this.hasta = hasta;
	}

	@Override
	public String toString() {
		return "[idPermiso: "+ this.idPermiso + " fecha: " + this.fecha + "lugar: " + this.getDesde() +  "]";
	}
}