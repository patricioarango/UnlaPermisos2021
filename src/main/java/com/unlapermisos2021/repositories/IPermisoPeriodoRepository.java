package com.unlapermisos2021.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.PermisoPeriodo;

@Repository
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo,Serializable>{

	@Query("SELECT p from PermisoPeriodo p inner join fetch p.pedido pe where (:fecha) BETWEEN fecha AND DATE_ADD(fecha, (:texto))  ")
	public Set<PermisoPeriodo> getAll(LocalDate fecha,String texto);
	
	@Query("SELECT p from PermisoPeriodo p inner join fetch p.pedido pe where persona_id = (:idPersona)")
	public Set<PermisoPeriodo> getAllPorIdPersona(int idPersona);
	public PermisoPeriodo getByIdPermiso(int idPermiso);
}