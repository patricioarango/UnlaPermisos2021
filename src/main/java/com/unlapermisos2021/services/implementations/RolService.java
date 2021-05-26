package com.unlapermisos2021.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.UserRoleConverter;
import com.unlapermisos2021.entities.UserRole;
import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.models.UserRoleModel;
import com.unlapermisos2021.models.UsuarioModel;
import com.unlapermisos2021.repositories.IRolRepository;
import com.unlapermisos2021.services.IRolService;

@Service
public class RolService implements IRolService{
	@Autowired 
	private IRolRepository rolRepo;
	
	@Autowired
	private UserRoleConverter rolConverter;
	
	@Override
	public UserRole findById(long id) {
		return rolRepo.findById(id);
	}

	@Override
	public List<UserRoleModel> getAll() {
		List<UserRoleModel> roles = new ArrayList<>();
		for(UserRole rol : rolRepo.findAll()){
			roles.add(rolConverter.entityToModel(rol));
		}
		return roles;
	}
	
	@Override
	public List<UserRoleModel> getAllEnabled(int enabled) {
		List<UserRoleModel> roles = new ArrayList<>();
		for(UserRole rol : rolRepo.findAllByEnabledTrue()){
			roles.add(rolConverter.entityToModel(rol));
		}
		return roles;
	}
	
	public UserRoleModel updateRol(UserRoleModel rol) {
		UserRole role = rolRepo.save(rolConverter.modeltoEntity(rol));
		return rolConverter.entityToModel(role);
	}
}
