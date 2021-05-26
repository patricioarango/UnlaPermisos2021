package com.unlapermisos2021.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.models.UsuarioModel;
import com.unlapermisos2021.services.implementations.UsuarioService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UsuarioService userService;
	
	@GetMapping("")
	public ModelAndView index(Authentication auth, HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView("home/home");
        UsuarioModel userModel =  userService.traerUsuarioYPerfilPorUsername(auth.getName());
        mav.addObject("usuario", userModel);
        return mav;
	}
	
	@GetMapping("/entrar")
	public ModelAndView entrar(Authentication auth, HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView("home/home");
        UsuarioModel userModel =  userService.traerUsuarioYPerfilPorId(3);
        mav.addObject("usuario", userModel);
        return mav;
	}
}
