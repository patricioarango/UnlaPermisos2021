package com.unlapermisos2021.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.unlapermisos2021.entities.UserRole;
import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.repositories.IUsuarioRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{

	@Autowired
	private IUsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)    {
		Usuario user =  userRepository.findByUsernameAndFetchPerfilEagerly(username);
 
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		UserRole rol = user.getRol();

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getRole());

		grantList.add(grantedAuthority); 

		UserDetails usuario = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);
		return usuario;

	}
}
