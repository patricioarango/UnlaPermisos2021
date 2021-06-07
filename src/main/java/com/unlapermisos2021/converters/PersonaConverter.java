package com.unlapermisos2021.converters;

import org.springframework.stereotype.Component;

import com.unlapermisos2021.entities.Persona;
import com.unlapermisos2021.models.PersonaModel;

@Component("personaConverter")
public class PersonaConverter {
	
	public PersonaModel entityToModel(Persona persona) {
		return new PersonaModel(persona.getIdPersona(), persona.getNombrePersona(), persona.getApellidoPersona(),persona.getDniPersona());
	}
	
	public Persona modelToEntity(PersonaModel personaModel) {
		return new Persona(personaModel.getIdPersona(), personaModel.getNombrePersona(), personaModel.getApellidoPersona(), personaModel.getDniPersona());
	}
}