package com.unlapermisos2021.services;

import com.unlapermisos2021.models.PersonaModel;

public interface IPersonaService {
	
	public PersonaModel findByDniPersona(long dni);
	public PersonaModel findByIdPersona(int id);
	public PersonaModel guardar(PersonaModel persona);
}
