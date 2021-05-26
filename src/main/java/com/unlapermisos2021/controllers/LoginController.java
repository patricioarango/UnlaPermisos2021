package com.unlapermisos2021.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.services.implementations.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public String index(){
		return ViewRoutesHelper.LOGIN;
	}

	@GetMapping("/exito")
	public String exito(Authentication auth, HttpSession session, Model model){
		System.out.print(auth.getName());	
		return ViewRoutesHelper.HOME;
	}

}
