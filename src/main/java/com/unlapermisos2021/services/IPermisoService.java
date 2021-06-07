package com.unlapermisos2021.services;

import com.unlapermisos2021.models.PermisoModel;

public interface IPermisoService {
	public PermisoModel guardar(PermisoModel permiso);

	public PermisoModel getByIdPermiso(int idPermiso);
}
