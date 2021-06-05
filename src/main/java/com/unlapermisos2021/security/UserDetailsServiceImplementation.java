package com.unlapermisos2021.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.repositories.IUsuarioRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)    {
		Usuario user =  userRepository.findByUsername(username);
		UserBuilder builder = null;
		builder = User.withUsername(username);
		builder.disabled(false);
		builder.password(user.getPassword());
		builder.authorities(new SimpleGrantedAuthority(user.getRol().getRole()));
		return builder.build();
	}
}
