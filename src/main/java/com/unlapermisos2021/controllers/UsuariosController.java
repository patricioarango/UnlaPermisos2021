package com.unlapermisos2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@GetMapping("/listar")
	public String listar() {
		return "usuarios/listado_usuarios";
	}
	
	@GetMapping("/nuevo")
	public String nuevo() {
		return "usuarios/form_usuario";
	}
}
