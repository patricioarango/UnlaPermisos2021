package com.unlapermisos2021.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unlapermisos2021.entities.Persona;


public interface IPersonaRepository extends JpaRepository<Persona, Serializable>{
	
	@Query("SELECT p from Persona p where dni_persona = (:dni) ")
	public Persona getByDniPersona(long dni);
	
	public Persona findByIdPersona(int id);
}
