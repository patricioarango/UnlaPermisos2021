package com.unlapermisos2021.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.PersonaConverter;
import com.unlapermisos2021.entities.Persona;
import com.unlapermisos2021.models.PersonaModel;
import com.unlapermisos2021.repositories.IPersonaRepository;
import com.unlapermisos2021.services.IPersonaService;

@Service
public class PersonaService implements IPersonaService{

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Autowired
	private IPersonaRepository personaRepo;
	
	@Override
	public PersonaModel findByDniPersona(long dni) {
		Persona persona = personaRepo.getByDniPersona(dni);
		PersonaModel personaModel = new PersonaModel();
		if (persona != null) personaModel = personaConverter.entityToModel(persona);
		return personaModel;
	}

	@Override
	public PersonaModel findByIdPersona(int id) {
		return personaConverter.entityToModel(personaRepo.findByIdPersona(id));
	}
	
	@Override
	public PersonaModel guardar(PersonaModel persona) {
		Persona personaSaved = personaRepo.save(personaConverter.modelToEntity(persona));
		return personaConverter.entityToModel(personaSaved);
	}
	
	@Override
	public List<Persona> getAll(){
		return personaRepo.findAll();
	}
}
