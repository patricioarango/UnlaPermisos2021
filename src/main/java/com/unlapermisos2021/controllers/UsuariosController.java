package com.unlapermisos2021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.unlapermisos2021.service.UserService;

@Controller
//@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	UserService userService;
	
	@GetMapping("/userForm")
	public String UserList(Model model) {
		model.addAttribute("UserList", userService.getAllUsers());
		return "usuarios/user-view";
	}
	
	/*
	@GetMapping("/nuevo")
	public String nuevo() {
		return "usuarios/form_usuario";
	}*/
}
