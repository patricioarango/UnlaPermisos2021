package com.unlapermisos2021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unlapermisos2021.entities.Permiso;
import com.unlapermisos2021.models.PermisoModel;

@Component
public class PermisoConverter {
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	public PermisoModel entityToModel(Permiso permiso) {
		return new PermisoModel(personaConverter.entityToModel(permiso.getPedido()),lugarConverter.entityToModel(permiso.getDesde()),lugarConverter.entityToModel(permiso.getHasta()),permiso.getFecha());
	}
	
	public Permiso modelToEntity(PermisoModel permiso) {
		return new Permiso(personaConverter.modelToEntity(permiso.getPedido()),lugarConverter.modelToEntity(permiso.getDesde()),lugarConverter.modelToEntity(permiso.getHasta()),
				permiso.getFecha());
	}
}
