package com.unlapermisos2021.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public Iterable<Usuario> getAllUsers() {
		return repository.findAll();
	}
	

}
