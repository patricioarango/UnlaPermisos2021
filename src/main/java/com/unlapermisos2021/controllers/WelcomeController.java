package com.unlapermisos2021.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.UsuarioModel;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@GetMapping("")
	public ModelAndView entrar(Authentication auth, HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.INDEX);
        return mav;
	}
	
	@GetMapping("/permiso")
	public ModelAndView permiso(Authentication auth, HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO);
        return mav;
	}
}
