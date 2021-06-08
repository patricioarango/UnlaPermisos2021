package com.unlapermisos2021.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.services.IPermisoDiarioService;
import com.unlapermisos2021.services.IPermisoPeriodoService;
import com.unlapermisos2021.services.IPermisoService;
import com.unlapermisos2021.services.IPersonaService;
import com.unlapermisos2021.services.IRodadoService;

@Controller
@RequestMapping("/busqueda_permisos")
public class BusquedaPermisosController {
	
	@Autowired 
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired 
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired 
	private IPermisoService permisoService;
	
	@Autowired 
	private IPersonaService personaService;
	
	@Autowired 
	private IRodadoService rodadoService;
	
	@GetMapping("/por_rodados")
	public ModelAndView por_rodados(Authentication auth, Model model,HttpSession session) {
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMINISTRADOR"))) {
			session.setAttribute("SessionRol", "ADMINISTRADOR");
		}
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("AUDITOR"))) {
			session.setAttribute("SessionRol", "AUDITOR");
		}
		
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.BUSQUEDA_RODADOS);
		model.addAttribute("rodados", rodadoService.getAll());
        return mav;
	}

	@GetMapping("/por_personas")
	public ModelAndView por_personas(Authentication auth, Model model,HttpSession session) {
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMINISTRADOR"))) {
			session.setAttribute("SessionRol", "ADMINISTRADOR");
		}
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("AUDITOR"))) {
			session.setAttribute("SessionRol", "AUDITOR");
		}
		
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.BUSQUEDA_PERSONAS);
		model.addAttribute("personas", personaService.getAll());
        return mav;
	}
	
	@GetMapping("/rodado/{id}")
	public ModelAndView rodado(@PathVariable("id") int id, Authentication auth, Model model,HttpSession session) {
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMINISTRADOR"))) {
			session.setAttribute("SessionRol", "ADMINISTRADOR");
		}
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("AUDITOR"))) {
			session.setAttribute("SessionRol", "AUDITOR");
		}
		
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.BUSQUEDA_RODADO_PERMISOS);
		model.addAttribute("permisosPeriodos", permisoPeriodoService.getAllPorIdRodado(id));
        return mav;
	}
	
	@GetMapping("/persona/{id}")
	public ModelAndView persona(@PathVariable("id") int id, Authentication auth, Model model,HttpSession session) {
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMINISTRADOR"))) {
			session.setAttribute("SessionRol", "ADMINISTRADOR");
		}
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("AUDITOR"))) {
			session.setAttribute("SessionRol", "AUDITOR");
		}
		
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.BUSQUEDA_PERSONAS_PERMISOS);
		model.addAttribute("permisosDiarios", permisoDiarioService.buscarPermisoDiarioPorIdPersona(id));
		model.addAttribute("permisosPeriodos", permisoPeriodoService.buscarPermisoPeriodosPorIdPersona(id));
        return mav;
	}
}
