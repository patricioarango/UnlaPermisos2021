package com.unlapermisos2021.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unlapermisos2021.entities.PermisoDiario;


public interface IPermisoDiarioRepository extends JpaRepository<PermisoDiario, Serializable>{

	@Query("SELECT p from PermisoDiario p inner join fetch p.pedido pe where fecha = (:fecha) ")
	public Set<PermisoDiario> findAllByFecha(LocalDate fecha);
	
	@Query("SELECT p from PermisoDiario p where persona_id = (:idPersona) and DATE(fecha) = DATE(now())")
	public Set<PermisoDiario> findAllActivosByIdPersona(int idPersona);
	
	public PermisoDiario getByIdPermiso(int idPermiso);
}
