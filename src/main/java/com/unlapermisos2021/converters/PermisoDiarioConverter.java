package com.unlapermisos2021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unlapermisos2021.entities.PermisoDiario;
import com.unlapermisos2021.models.PermisoDiarioModel;

@Component
public class PermisoDiarioConverter {
	
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	
	public PermisoDiarioModel entityToModel(PermisoDiario permisoDiario) {
		return new PermisoDiarioModel(permisoDiario.getIdPermiso(),permisoDiario.getMotivo());
	}

	public PermisoDiario modelToEntity (PermisoDiarioModel permisoDiarioModel) {
		return new PermisoDiario(permisoDiarioModel.getIdPermiso(),permisoDiarioModel.getMotivo());
	}
}	
