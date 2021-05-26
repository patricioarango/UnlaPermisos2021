package com.unlapermisos2021.services;

import java.util.List;

import com.unlapermisos2021.entities.UserRole;
import com.unlapermisos2021.models.UserRoleModel;

public interface IRolService {
	public List<UserRoleModel> getAll();
	
	public UserRole findById(long id);
	
	public List<UserRoleModel> getAllEnabled(int enabled);
		
	public UserRoleModel updateRol(UserRoleModel rol);
}
