package com.unlapermisos2021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.models.UsuarioModel;
import com.unlapermisos2021.services.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuarioService userService;
   
	@GetMapping("/listar")
	public String listar() {
		return "usuarios/listado_usuarios";
	}
	
	@GetMapping("/nuevo")
	public String nuevo() {
		return "usuarios/form_usuario";
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificar(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("usuarios/form_usuario");
        UsuarioModel userModel =  userService.traerUsuarioYPerfilPorId(id);
        mav.addObject("usuario", userModel);
        return mav;
	}
}
