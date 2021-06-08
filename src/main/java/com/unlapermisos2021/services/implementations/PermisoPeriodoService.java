package com.unlapermisos2021.services.implementations;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosActivos(){
		LocalDate fecha = LocalDate.now();
		Set<PermisoPeriodoModel> aux = new HashSet<>();
		Set<PermisoPeriodo> permisos = permisoPeriodoRepo.getAll(fecha,"INTERVAL cantdias DAY");
		for (PermisoPeriodo p : permisos) {
			aux.add(permisoPeriodoConverter.entityToModel(p));
		}
		return aux;
	}			
	
	@Override 
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosActivosPorIdPersona(int idPersona){
		Set<PermisoPeriodoModel> aux = new HashSet<>();
		LocalDate fecha = LocalDate.now();
		Set<PermisoPeriodo> permisos = permisoPeriodoRepo.getAllPorIdPersona(idPersona);
		for (PermisoPeriodo p : permisos) {
			LocalDate fechaFin = p.getFecha().plusDays(p.getCantDias()-1);
			LocalDate hoy = LocalDate.now();
			if (!fechaFin.isBefore(hoy) && !fecha.isAfter(hoy)) {
				aux.add(permisoPeriodoConverter.entityToModel(p));
			}
		}
		return aux;
	}	

	@Override 
	public Set<PermisoPeriodoModel> buscarPermisoPeriodosPorIdPersona(int idPersona){
		Set<PermisoPeriodoModel> aux = new HashSet<>();
		LocalDate fecha = LocalDate.now();
		Set<PermisoPeriodo> permisos = permisoPeriodoRepo.getAllPorIdPersona(idPersona);
		for (PermisoPeriodo p : permisos) {
			aux.add(permisoPeriodoConverter.entityToModel(p));
		}
		return aux;
	}
	
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

	@Override
	public Set<PermisoPeriodoModel> getAllPorIdRodado(int idRodado){
		Set<PermisoPeriodoModel> aux = new HashSet<>();
		Set<PermisoPeriodo> permisos = permisoPeriodoRepo.findByRodado(idRodado);
		for (PermisoPeriodo p : permisos) {
			aux.add(permisoPeriodoConverter.entityToModel(p));
		}
		return aux;
	}
}
