package com.unlapermisos2021.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "permiso") 
@Inheritance(strategy = InheritanceType.JOINED)
public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	protected Persona pedido;

	@Column(name = "fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fecha;

	// En el diagrama aparece como "DESDE HASTA", para entenderlo mejor lo renombre
	// "LUGARES"
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_permiso_lugar", joinColumns 
	= @JoinColumn(name = "permiso_id"), inverseJoinColumns
	= @JoinColumn(name = "lugar_id"))
	private Set<Lugar> lugares = new HashSet<>();

	public Permiso() {
		super();
	}


	public Permiso(int idPermiso) {
		super();
		this.idPermiso = idPermiso;
	}
	
	public Permiso(int idPermiso,Persona persona,LocalDate fecha) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = persona;
		this.fecha = fecha;
	}


	public Permiso(Persona persona,LocalDate fecha) {
		super();
		this.pedido = persona;
		this.fecha = fecha;
	}
	
	public Permiso(int idPermiso, Persona persona, Set<Lugar> lugares, LocalDate fecha) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = persona;
		this.fecha = fecha;
		this.setLugares(lugares);
		}

	public Permiso(int idPermiso, Persona persona, Set<Lugar> lugares) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = persona;
		this.setLugares(lugares);
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

	public void setPedido(Persona persona) {
		this.pedido = persona;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Lugar> getLugares() {
		return lugares;
	}

	public void setLugares(Set<Lugar> lugares) {
		this.lugares = lugares;
	}
}
