package com.unlapermisos2021.services;

import java.util.List;

import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.models.UsuarioModel;

public interface IUsuarioService {

	public List<UsuarioModel> getAll();
	
	public Usuario findById(long id);
	
	public List<UsuarioModel> getAllEnabled();
		
	public UsuarioModel updateUser(UsuarioModel userModel);

	public UsuarioModel traerUsuarioYPerfilPorId(long id);

	public UsuarioModel traerUsuarioYPerfilPorUsername(String username);
	
	//public UsuarioModel traerUsuarioPorId(long id);
	//public UsuarioModel traerUsuarioPorUsername(String username);
	
	//public UsuarioModel traerUsuarioPorDni(int dni);
	

	
	//public boolean remove (long idUsuario);
}
