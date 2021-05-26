package com.unlapermisos2021.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.converters.UsuarioConverter;
import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.UsuarioModel;
import com.unlapermisos2021.services.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuarioService userService;
	@Autowired
	private UsuarioConverter userConverter;
   
	@GetMapping("/listar")
	public ModelAndView listar(Model model,HttpSession session) {
		session.setAttribute("SessionRol", "ADMINISTRADOR");
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.USUARIOS_LISTADO);
		model.addAttribute("usuarios", userService.getAllEnabled(1));
        return mav;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView nuevo(Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.USUARIOS_FORM);
        UsuarioModel userModel =  new UsuarioModel();
        mav.addObject("usuario", userModel);
        return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificar(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.USUARIOS_FORM);
        UsuarioModel userModel =  userService.traerUsuarioYPerfilPorId(id);
        mav.addObject("usuario", userModel);
        return mav;
	}
	
	@GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") long id){
		Usuario userModel =  userService.findById(id);
		System.out.println(userModel);
		userModel.setEnabled(false);
		userService.updateUser(userModel);
		return "redirect:/usuarios/listar";
    }
}
