package com.unlapermisos2021.services.implementations;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.LugarConverter;
import com.unlapermisos2021.entities.Lugar;
import com.unlapermisos2021.models.LugarModel;
import com.unlapermisos2021.repositories.ILugarRepository;
import com.unlapermisos2021.services.ILugarService;

@Service
public class LugarService implements ILugarService{

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;
	
	@Autowired
	private ILugarRepository lugarRepo;
	
	@Override
	public LugarModel guardar(LugarModel lugar) {
		Lugar lugarDB = lugarRepo.save(lugarConverter.modelToEntity(lugar));
		return lugarConverter.entityToModel(lugarDB);
	}
	
	@Override 
	public Set<LugarModel> getAll(){ 
		Set<LugarModel> lugares = new HashSet<>();
		for(Lugar l : lugarRepo.findAll()){
			lugares.add(lugarConverter.entityToModel(l));
		}
		return lugares;
	}
	
	@Override 
	public LugarModel findByIdLugar(int id){
		return lugarConverter.entityToModel(lugarRepo.findByIdLugar(id));
	}

}
