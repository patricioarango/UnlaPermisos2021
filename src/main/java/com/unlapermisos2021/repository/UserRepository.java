package com.unlapermisos2021.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.Usuario;

@Repository
public interface UserRepository extends CrudRepository <Usuario,Long>{

	public Set<Usuario> findByNombre(String name);
}
