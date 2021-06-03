package com.unlapermisos2021.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetails;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return  new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());     
	}

	String[] resources = new String[]{
			"/bootstrap/**","/images/**","/css/**","/icons/**","/js/**"
    };
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests() 
		.antMatchers(resources).permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/home/*").hasAnyAuthority("ADMINISTRADOR","AUDITOR")
		.antMatchers("/usuarios/listar").hasAnyAuthority("ADMINISTRADOR","AUDITOR")
		.antMatchers("/roles/listar").hasAnyAuthority("ADMINISTRADOR","AUDITOR")
		.antMatchers("/usuarios/nuevo").hasAuthority("ADMINISTRADOR")
		.antMatchers("/usuarios/modificar").hasAuthority("ADMINISTRADOR")
		.antMatchers("/roles/nuevo").hasAuthority("ADMINISTRADOR")
		.antMatchers("/roles/modificar").hasAuthority("ADMINISTRADOR")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		//.loginPage("/login")
		.defaultSuccessUrl("/home/entrar",true)
		.usernameParameter("username")
		.passwordParameter("password");
	}

}
