package com.unlapermisos2021.services;

import java.time.LocalDate;
import java.util.Set;
import com.unlapermisos2021.models.PermisoDiarioModel;

public interface IPermisoDiarioService {

	public Set<PermisoDiarioModel> buscarPermisoDiarioPorIdPersona(int idPersona);
	public Set<PermisoDiarioModel> buscarPermisoDiarioPorFecha(LocalDate fecha);
	public Set<PermisoDiarioModel> buscarPermisoDiarioEntreFechas(LocalDate desde,LocalDate hasta);
	public Set<PermisoDiarioModel> buscarPermisoDiarioActivoPorIdPersona(int idPersona);
	public PermisoDiarioModel guardar(PermisoDiarioModel permiso);
	public PermisoDiarioModel findByIdPermiso(int idPermiso);

}
