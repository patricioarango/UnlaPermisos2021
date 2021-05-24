package com.unlapermisos2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolesController {
	
	@GetMapping("/listar")
	public String listar() {
		return "roles/listado_roles";
	}
	
	@GetMapping("/nuevo")
	public String nuevo() {
		return "roles/form_rol";
	}
}
