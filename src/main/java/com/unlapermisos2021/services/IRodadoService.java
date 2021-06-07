package com.unlapermisos2021.services;

import java.util.Set;

import com.unlapermisos2021.models.RodadoModel;

public interface IRodadoService {

	public RodadoModel guardar(RodadoModel rodado);
	
	public Set<RodadoModel> getAll();
}
