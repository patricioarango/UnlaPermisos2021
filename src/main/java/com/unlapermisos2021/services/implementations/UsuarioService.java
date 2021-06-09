package com.unlapermisos2021.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.converters.UsuarioConverter;
import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.models.UsuarioModel;
import com.unlapermisos2021.repositories.IUsuarioRepository;
import com.unlapermisos2021.services.IUsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{

	@Autowired 
	private IUsuarioRepository userRepo;
	
	@Autowired
	private UsuarioConverter userConverter;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	@Override
	public UsuarioModel traerUsuarioYPerfilPorId(long id) {
		UsuarioModel usuario = userConverter.entityToModel(userRepo.findById(id));
		return usuario;
	}
	@Override
	public UsuarioModel traerUsuarioYPerfilPorUsername(String username){
		UsuarioModel usuario = userConverter.entityToModel(userRepo.findByUsernameAndFetchPerfilEagerly(username));
		return usuario;
	}

	@Override
	public List<UsuarioModel> getAll() {
		List<UsuarioModel> usuarios = new ArrayList<>();
		for(Usuario u : userRepo.findAll()){
			usuarios.add(userConverter.entityToModel(u));
		}
		return usuarios;
	}
	
	@Override
	public List<UsuarioModel> getAllEnabled() {
		List<UsuarioModel> usuarios = new ArrayList<>();
		for(Usuario u : userRepo.findAllByEnabledTrue()){
			usuarios.add(userConverter.entityToModel(u));
		}
		return usuarios;
	}
	@Override
	public UsuarioModel updateUser(UsuarioModel usuario){
		usuario.setPassword(passwordEnconder.encode(usuario.getPassword()));
		Usuario user = userRepo.save(userConverter.modeltoEntity(usuario));
		return userConverter.entityToModel(user);
	}
	
	@Override
	public Usuario findById(long id) {
		return userRepo.findById(id);
	}
}
