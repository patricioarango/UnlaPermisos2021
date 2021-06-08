package com.unlapermisos2021.services;

import java.util.List;

import com.unlapermisos2021.entities.Persona;
import com.unlapermisos2021.models.PersonaModel;

public interface IPersonaService {
	
	public PersonaModel findByDniPersona(long dni);
	public PersonaModel findByIdPersona(int id);
	public PersonaModel guardar(PersonaModel persona);
	public List<Persona> getAll();
}
