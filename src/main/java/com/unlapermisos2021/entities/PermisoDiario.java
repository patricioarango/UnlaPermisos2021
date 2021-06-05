package com.unlapermisos2021.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "permisodiario")
@PrimaryKeyJoinColumn(name="idPermiso")
public class PermisoDiario extends Permiso{

	@Column(name="motivo")
	private String motivo;

	public PermisoDiario() {

	}

	public PermisoDiario(int idPermiso, Persona pedido, Set<Lugar> lugares, LocalDate fecha,String motivo) {
		super(idPermiso, pedido, lugares, fecha);
		this.motivo = motivo;
	}

	public PermisoDiario(int idPermiso, Persona pedido, Set<Lugar> lugares) {
		super(idPermiso, pedido, lugares);
	}
	
	public PermisoDiario(int idPermiso,String motivo) {
		super(idPermiso);
		this.motivo = motivo;
	}
	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}