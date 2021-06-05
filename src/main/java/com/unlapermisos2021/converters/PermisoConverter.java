package com.unlapermisos2021.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unlapermisos2021.entities.Lugar;
import com.unlapermisos2021.entities.Permiso;
import com.unlapermisos2021.models.LugarModel;
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
		return new PermisoModel(permiso.getIdPermiso(),personaConverter.entityToModel(permiso.getPedido()),permiso.getFecha());
	}
	
	public Permiso modelToEntity(PermisoModel permiso) {
		Set<Lugar> desdeHasta = new HashSet<>();
		for(LugarModel l : permiso.getLugares()){
			desdeHasta.add(lugarConverter.modelToEntity(l));
		}
		return new Permiso(permiso.getIdPermiso(),personaConverter.modelToEntity(permiso.getPedido()),permiso.getFecha());
	}
}
