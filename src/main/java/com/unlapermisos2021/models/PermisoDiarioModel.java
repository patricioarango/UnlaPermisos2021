package com.unlapermisos2021.models;
import java.time.LocalDate;

public class PermisoDiarioModel extends PermisoModel{

	private String motivo;

	public PermisoDiarioModel() {

	}

	public PermisoDiarioModel(int idPermiso,PersonaModel pedido, LugarModel desde, LugarModel hasta, LocalDate fecha, String motivo) {
		super(idPermiso,pedido,desde,hasta,fecha);
		this.motivo = motivo;
	}
	
	public PermisoDiarioModel(PersonaModel pedido, LugarModel desde, LugarModel hasta, LocalDate fecha, String motivo) {
		super(pedido,desde,hasta,fecha);
		this.motivo = motivo;
	}
		
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
		return result;
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermisoDiarioModel other = (PermisoDiarioModel) obj;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "[motivo: "+ this.motivo + "]";
	}
}
