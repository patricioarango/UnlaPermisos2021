package com.unlapermisos2021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unlapermisos2021.entities.PermisoPeriodo;
import com.unlapermisos2021.models.PermisoPeriodoModel;

@Component
public class PermisoPeriodoConverter {

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	
	public PermisoPeriodoModel entityToModel(PermisoPeriodo permiso) {
		return new PermisoPeriodoModel(permiso.getIdPermiso(),personaConverter.entityToModel(permiso.getPedido()),lugarConverter.entityToModel(permiso.getDesde()),lugarConverter.entityToModel(permiso.getHasta()),permiso.getFecha(),permiso.getCantDias(),permiso.isVacaciones(),rodadoConverter.entityToModel(permiso.getRodado()));
	}
	
	public PermisoPeriodo modelToEntity(PermisoPeriodoModel permiso) {
		return new PermisoPeriodo(permiso.getIdPermiso(),personaConverter.modelToEntity(permiso.getPedido()),lugarConverter.modelToEntity(permiso.getDesde()),lugarConverter.modelToEntity(permiso.getHasta()),permiso.getFecha(),permiso.getCantDias(),permiso.isVacaciones(),rodadoConverter.modelToEntity(permiso.getRodado()));
	}
}
