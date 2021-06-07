package com.unlapermisos2021.services;

import java.time.LocalDate;
import java.util.Set;
import com.unlapermisos2021.models.PermisoDiarioModel;

public interface IPermisoDiarioService {

	public Set<PermisoDiarioModel> buscarPermisoDiarioPorFecha(LocalDate fecha);
	public Set<PermisoDiarioModel> buscarPermisoDiarioActivoPorIdPersona(int idPersona);
	public PermisoDiarioModel guardar(PermisoDiarioModel permiso);
	public PermisoDiarioModel findByIdPermiso(int idPermiso);

}
