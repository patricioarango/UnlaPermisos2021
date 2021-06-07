package com.unlapermisos2021.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unlapermisos2021.entities.PermisoPeriodo;

public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo,Serializable>{

	public PermisoPeriodo getByIdPermiso(int idPermiso);
}
