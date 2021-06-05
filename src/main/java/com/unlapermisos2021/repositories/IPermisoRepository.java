package com.unlapermisos2021.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unlapermisos2021.entities.Permiso;

public interface IPermisoRepository extends JpaRepository<Permiso, Serializable>{

	public Permiso getByIdPermiso(int id);
}
