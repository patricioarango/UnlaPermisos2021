package com.unlapermisos2021.services;

import java.util.Set;

import com.unlapermisos2021.models.PermisoPeriodoModel;

public interface IPermisoPeriodoService {
	
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosActivos();
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosActivosPorIdPersona(int idPersona);
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosPorIdPersona(int idPersona);
	public PermisoPeriodoModel guardar(PermisoPeriodoModel permiso);
	public PermisoPeriodoModel findByIdPermiso(int idPermiso);
	public Set<PermisoPeriodoModel> getAllPorIdRodado(int idRodado);
}
