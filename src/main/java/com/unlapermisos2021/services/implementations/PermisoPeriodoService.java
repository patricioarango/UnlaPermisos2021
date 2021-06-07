package com.unlapermisos2021.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.PermisoPeriodoConverter;
import com.unlapermisos2021.entities.PermisoPeriodo;
import com.unlapermisos2021.models.PermisoPeriodoModel;
import com.unlapermisos2021.repositories.IPermisoPeriodoRepository;
import com.unlapermisos2021.services.IPermisoPeriodoService;

@Service
public class PermisoPeriodoService implements IPermisoPeriodoService{
	@Autowired
	@Qualifier("permisoPeriodoConverter")
	private PermisoPeriodoConverter permisoPeriodoConverter;
	
	@Autowired
	private IPermisoPeriodoRepository permisoPeriodoRepo;

	@Override
	public PermisoPeriodoModel guardar(PermisoPeriodoModel permiso) {
		PermisoPeriodo permisoG = permisoPeriodoRepo.save(permisoPeriodoConverter.modelToEntity(permiso));
		return permisoPeriodoConverter.entityToModel(permisoG);
	}

	@Override
	public PermisoPeriodoModel findByIdPermiso(int idPermiso) {
		PermisoPeriodoModel permisoDB = permisoPeriodoConverter.entityToModel(permisoPeriodoRepo.getByIdPermiso(idPermiso));
		return permisoDB;
	}

}
