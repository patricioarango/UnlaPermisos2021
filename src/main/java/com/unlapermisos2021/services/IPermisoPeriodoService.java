package com.unlapermisos2021.services;

import com.unlapermisos2021.models.PermisoPeriodoModel;

public interface IPermisoPeriodoService {
	
	public PermisoPeriodoModel guardar(PermisoPeriodoModel permiso);
	public PermisoPeriodoModel findByIdPermiso(int idPermiso);
}
