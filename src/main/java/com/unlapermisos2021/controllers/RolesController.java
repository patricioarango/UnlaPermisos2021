package com.unlapermisos2021.controllers;

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

import com.unlapermisos2021.converters.UserRoleConverter;
import com.unlapermisos2021.entities.UserRole;
import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.UserRoleModel;
import com.unlapermisos2021.services.IRolService;

@Controller
@RequestMapping("/roles")
public class RolesController {
	
	@Autowired
	IRolService rolService;
	
	@Autowired
	UserRoleConverter rolConverter;
	
	@GetMapping("/listar")
	public ModelAndView listar(Model model,HttpSession session) {
		session.setAttribute("SessionRol", "ADMINISTRADOR");
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.ROLES_LISTADO);
		model.addAttribute("roles", rolService.getAllEnabled(1));
        return mav;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView nuevo(Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.ROLES_FORM);
		UserRoleModel rolModel =  new UserRoleModel();
        mav.addObject("rol", rolModel);
        return mav;
	}
	
	@GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") long id){
		UserRole rol =  rolService.findById(id);
		rol.setEnabled(false);
		rolService.updateRol(rolConverter.entityToModel(rol));
		return "redirect:/roles/listar";
    }
	
	@PostMapping("/guardar")
    public String guardar(@ModelAttribute("rol") UserRoleModel rol){
		rolService.updateRol(rol);
		return "redirect:/roles/listar";
    }
}
