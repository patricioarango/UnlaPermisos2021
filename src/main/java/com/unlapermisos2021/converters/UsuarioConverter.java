package com.unlapermisos2021.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.models.UsuarioModel;

@Component
public class UsuarioConverter {

	@Autowired
	private UserRoleConverter userRoleConverter;
	
	public UsuarioModel entityToModel(Usuario user) {
		return new UsuarioModel(user.getId(),user.getNombre(), user.getApellido(), user.getEmail(), user.getUsername(), user.getPassword(),user.getTipo_documento(), user.getNro_documento(), user.getRol(), user.isEnabled());
	}

	public Usuario modeltoEntity(UsuarioModel user) {
		return new Usuario(user.getId(),user.getNombre(), user.getApellido(), user.getEmail(), user.getUsername(), user.getPassword(),user.getTipo_documento(), user.getNro_documento(), user.getRol(),user.isEnabled());
	}
}