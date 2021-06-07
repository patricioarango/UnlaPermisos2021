package com.unlapermisos2021.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.PermisoConverter;
import com.unlapermisos2021.entities.Permiso;
import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.models.PermisoModel;
import com.unlapermisos2021.repositories.IPermisoRepository;
import com.unlapermisos2021.services.IPermisoService;

@Service
public class PermisoService implements IPermisoService{

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	@Autowired
	private IPermisoRepository permisoRepo;
	
	public PermisoModel guardar(PermisoModel permiso) {
		Permiso permisoDB = permisoRepo.save(permisoConverter.modelToEntity(permiso));
		return permisoConverter.entityToModel(permisoDB);
	}
	
	@Override
	public PermisoModel getByIdPermiso(int id) {
		Permiso permiso = permisoRepo.getByIdPermiso(id);
		PermisoModel permisoModel = new PermisoModel(); 
		if(permiso != null) permisoModel = permisoConverter.entityToModel(permiso);
		return permisoModel;
	}
}
