package com.unlapermisos2021.services;

import java.time.LocalDate;
import java.util.Set;

import com.unlapermisos2021.models.PermisoPeriodoModel;

public interface IPermisoPeriodoService {
	
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosActivos();
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosEntreFechas(LocalDate desde,LocalDate hasta);
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosEntreFechasYLugares(LocalDate desde,LocalDate hasta,int lugar_desde, int lugar_hasta);
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosActivosPorIdPersona(int idPersona);
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosPorIdPersona(int idPersona);
	public PermisoPeriodoModel guardar(PermisoPeriodoModel permiso);
	public PermisoPeriodoModel findByIdPermiso(int idPermiso);
	public Set<PermisoPeriodoModel> getAllPorIdRodado(int idRodado);
}
