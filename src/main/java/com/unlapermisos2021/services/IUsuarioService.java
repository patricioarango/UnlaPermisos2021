package com.unlapermisos2021.services;

import java.util.List;

import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.models.UsuarioModel;

public interface IUsuarioService {

	public List<UsuarioModel> getAll();
	
	public List<UsuarioModel> getAllEnabled(int enabled);
		
	//public UsuarioModel traerUsuarioPorId(long id);

	public UsuarioModel traerUsuarioYPerfilPorId(long id);

	public UsuarioModel traerUsuarioYPerfilPorUsername(String username);
	
	//public UsuarioModel traerUsuarioPorUsername(String username);
	
	//public UsuarioModel traerUsuarioPorDni(int dni);
	
	public UsuarioModel updateUser(UsuarioModel usuario);
	
	//public boolean remove (long idUsuario);
}
