package com.unlapermisos2021.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.UsuarioConverter;
import com.unlapermisos2021.models.UsuarioModel;
import com.unlapermisos2021.repositories.IUsuarioRepository;
import com.unlapermisos2021.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired 
	private IUsuarioRepository userRepo;
	
	@Autowired
	private UsuarioConverter userConverter;
	
	@Override
	public UsuarioModel traerUsuarioYPerfilPorId(long id) {
		UsuarioModel usuario = userConverter.entityToModel(userRepo.findById(id));
		return usuario;
	}

}
