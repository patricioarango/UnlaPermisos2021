package com.unlapermisos2021.services.implementations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.RodadoConverter;
import com.unlapermisos2021.entities.Rodado;
import com.unlapermisos2021.models.RodadoModel;
import com.unlapermisos2021.repositories.IRodadoRepository;
import com.unlapermisos2021.services.IRodadoService;

@Service
public class RodadoService implements IRodadoService{

	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;
	@Autowired 
	private IRodadoRepository rodadoRepo;
	
	@Override
	public RodadoModel guardar(RodadoModel rodado) {
		Rodado rodadoDB = rodadoRepo.save(rodadoConverter.modelToEntity(rodado));
		return rodadoConverter.entityToModel(rodadoDB);
	}

	public Set<RodadoModel> getAll(){
		Set<RodadoModel> aux = new HashSet<>();
		List<Rodado> rodados = rodadoRepo.findAll();
		for(Rodado r : rodados) {
			aux.add(rodadoConverter.entityToModel(r));
		}
		return aux;
	}
}
