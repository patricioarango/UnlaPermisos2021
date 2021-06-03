package com.unlapermisos2021.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")  //->Con esta linea se crea una sola tabla con los datos de las clases hijas.
//@Inheritance(strategy= InheritanceType.JOINED)//->Con esta linea se crea una tabla para cada clase->
public class Permiso {                            //A tener en cuenta:
                                                  //Para conseguir un objeto se hará join con las tablas necesarias.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPermiso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	private Persona persona;

	@Column(name = "fecha")
	private LocalDate fecha;

	// En el diagrama aparece como "DESDE HASTA", para entenderlo mejor lo renombre "LUGARES"
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_permiso_lugar", joinColumns 
	= @JoinColumn(name = "ID_PERMISO"), inverseJoinColumns
	= @JoinColumn(name = "ID_LUGAR"))
	private List<Lugar> lugares;

	public Permiso() {

	}

	public Permiso(int idPermiso, Persona persona, LocalDate fecha) {
		super();
		this.idPermiso = idPermiso;
		this.persona = persona;
		this.fecha = fecha;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
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
