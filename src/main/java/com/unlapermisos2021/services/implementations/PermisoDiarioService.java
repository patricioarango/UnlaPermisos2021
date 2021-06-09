package com.unlapermisos2021.services.implementations;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.PermisoDiarioConverter;
import com.unlapermisos2021.entities.PermisoDiario;
import com.unlapermisos2021.models.PermisoDiarioModel;
import com.unlapermisos2021.repositories.IPermisoDiarioRepository;
import com.unlapermisos2021.services.IPermisoDiarioService;

@Service
public class PermisoDiarioService implements IPermisoDiarioService{

	@Autowired
	@Qualifier("permisoDiarioConverter")
	private PermisoDiarioConverter permisoDiarioConverter;
	
	@Autowired 
	private IPermisoDiarioRepository permisoDiarioRepo;
	
	@Override
	public Set<PermisoDiarioModel> buscarPermisoDiarioPorFecha(LocalDate fecha) {
		Set<PermisoDiarioModel> aux = new HashSet<>();
		Set<PermisoDiario> permisos = permisoDiarioRepo.findAllByFecha(fecha);
		for (PermisoDiario p : permisos) {
			aux.add(permisoDiarioConverter.entityToModel(p));
		}
		return aux;
	}
	
	public Set<PermisoDiarioModel> buscarPermisoDiarioActivoPorIdPersona(int idPersona){
		Set<PermisoDiarioModel> aux = new HashSet<>();
		Set<PermisoDiario> permisos = permisoDiarioRepo.findAllActivosByIdPersona(idPersona);
		for (PermisoDiario p : permisos) {
			aux.add(permisoDiarioConverter.entityToModel(p));
		}
		return aux;
	}

	public Set<PermisoDiarioModel> buscarPermisoDiarioPorIdPersona(int idPersona){
		Set<PermisoDiarioModel> aux = new HashSet<>();
		Set<PermisoDiario> permisos = permisoDiarioRepo.findTodosByIdPersona(idPersona);
		for (PermisoDiario p : permisos) {
			aux.add(permisoDiarioConverter.entityToModel(p));
		}
		return aux;
	}
	
	public PermisoDiarioModel guardar(PermisoDiarioModel permiso) {
		PermisoDiario permisoD =  permisoDiarioRepo.save(permisoDiarioConverter.modelToEntity(permiso));
		return permisoDiarioConverter.entityToModel(permisoD);
	}
	
	public PermisoDiarioModel findByIdPermiso(int idPermiso) {
		PermisoDiarioModel permiso = permisoDiarioConverter.entityToModel(permisoDiarioRepo.getByIdPermiso(idPermiso));
		return permiso;
	}
	
	public Set<PermisoDiarioModel> buscarPermisoDiarioEntreFechas(LocalDate desde,LocalDate hasta){
		Set<PermisoDiarioModel> aux = new HashSet<>();
		Set<PermisoDiario> permisos = permisoDiarioRepo.findEntreFechas(desde,hasta);
		for (PermisoDiario p : permisos) {
			aux.add(permisoDiarioConverter.entityToModel(p));
		}
		return aux;
	}
	
	public Set<PermisoDiarioModel> buscarPermisoDiarioEntreFechasYLugares(LocalDate desde,LocalDate hasta,int lugar_desde, int lugar_hasta){
		Set<PermisoDiarioModel> aux = new HashSet<>();
		Set<PermisoDiario> permisos = permisoDiarioRepo.findEntreFechasYLugares(desde,hasta,lugar_desde,lugar_hasta);
		for (PermisoDiario p : permisos) {
			aux.add(permisoDiarioConverter.entityToModel(p));
		}
		return aux;
	}
}
