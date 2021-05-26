package com.unlapermisos2021.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.converters.UsuarioConverter;
import com.unlapermisos2021.entities.Tipo_documento;
import com.unlapermisos2021.entities.Usuario;
import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.UserRoleModel;
import com.unlapermisos2021.models.UsuarioModel;
import com.unlapermisos2021.services.IRolService;
import com.unlapermisos2021.services.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private IRolService rolService;
	
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
        model.addAttribute("roles", rolService.getAllEnabled(1));
        mav.addObject("usuario", userModel);
        return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public ModelAndView modificar(@PathVariable("id") long id, Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.USUARIOS_FORM);
        UsuarioModel userModel =  userService.traerUsuarioYPerfilPorId(id);
        model.addAttribute("roles", rolService.getAllEnabled(1));
        mav.addObject("usuario", userModel);
        return mav;
	}
	
	@GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") long id){
		Usuario userModel =  userService.findById(id);
		userModel.setEnabled(false);
		userService.updateUser(userConverter.entityToModel(userModel));
		return "redirect:/usuarios/listar";
    }

	@PostMapping("/guardar")
    public String guardar(@ModelAttribute("usuario") UsuarioModel usuario){
		usuario.setEnabled(true);
		//TODO si el id es 0, es un create, set createdAt
		userService.updateUser(usuario);
		return "redirect:/usuarios/listar";
    }
	
	@GetMapping("/exportarpdf")
	public void exportarpdf() {
		
	}
}
