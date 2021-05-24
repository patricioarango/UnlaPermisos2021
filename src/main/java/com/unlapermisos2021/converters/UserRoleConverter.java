package com.unlapermisos2021.converters;

import org.springframework.stereotype.Component;

import com.unlapermisos2021.entities.UserRole;
import com.unlapermisos2021.models.UserRoleModel;

@Component
public class UserRoleConverter {
	
	public UserRoleModel entityToModel(UserRole rol) {
		return new UserRoleModel(rol.getRole());
	}

	public UserRole modeltoEntity(UserRoleModel rol) {
		return new UserRole(rol.getRole());
	}
}
