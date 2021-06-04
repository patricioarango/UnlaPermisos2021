package com.unlapermisos2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.PersonaModel;


@Controller
@RequestMapping("/")
public class PermisoController {

	@GetMapping("")
	public ModelAndView index(Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.INDEX);
        return mav;
	}
	
	@GetMapping("/permiso/ingresar_dni")
	public ModelAndView ingresar_dni(Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_DNI);
		PersonaModel persona =  new PersonaModel();
        mav.addObject("persona", persona);
        return mav;
	}

	@PostMapping("/permiso/verificar_dni")
	public ModelAndView verificar_dni(Model model,@ModelAttribute("persona") PersonaModel persona) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_DNI);
        return mav;
	}

}
