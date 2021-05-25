package com.unlapermisos2021.service;

import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.Usuario;


public interface UserService {

	public Iterable<Usuario> getAllUsers();		

}
