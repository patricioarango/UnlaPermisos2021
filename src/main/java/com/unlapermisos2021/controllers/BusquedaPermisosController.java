package com.unlapermisos2021.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.PermisoDiarioModel;
import com.unlapermisos2021.models.PermisoPeriodoModel;
import com.unlapermisos2021.services.ILugarService;
import com.unlapermisos2021.services.IPermisoDiarioService;
import com.unlapermisos2021.services.IPermisoPeriodoService;
import com.unlapermisos2021.services.IPermisoService;
import com.unlapermisos2021.services.IPersonaService;
import com.unlapermisos2021.services.IRodadoService;

@Controller
@RequestMapping("/busqueda_permisos")
public class BusquedaPermisosController {
	Logger logger = LoggerFactory.getLogger(PermisoController.class);
	
	@Autowired 
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired 
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired 
	private IPermisoService permisoService;
	
	@Autowired 
	private ILugarService lugarService;
	
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
	
	@GetMapping("/activos_entre_fechas")
	public ModelAndView activos_entre_fechas(@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate desde,@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate hasta, Authentication auth, Model model,HttpSession session) {
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMINISTRADOR"))) {
			session.setAttribute("SessionRol", "ADMINISTRADOR");
		}
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("AUDITOR"))) {
			session.setAttribute("SessionRol", "AUDITOR");
		}
		
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.BUSQUEDA_ACTIVOS_ENTRE_FECHAS);
		if(desde != null && hasta != null) {
			Set<PermisoDiarioModel> permisosDiarios = permisoDiarioService.buscarPermisoDiarioEntreFechas(desde,hasta);
			if(permisosDiarios.size() > 0) {
				model.addAttribute("permisosDiarios",permisosDiarios);
			}
			Set<PermisoPeriodoModel> permisosPeriodos = permisoPeriodoService.buscarPermisoPeriodosEntreFechas(desde,hasta);
			if(permisosPeriodos.size() > 0) {
				model.addAttribute("permisosPeriodos",permisosPeriodos);
			}
		}
        return mav;
	}
	
	@GetMapping("/activos_entre_fechas_y_lugares")
	public ModelAndView activos_entre_fechas_y_lugares(@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate desde,@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate hasta, @RequestParam(required=false,defaultValue = "0") int lugar_desde, @RequestParam(required=false,defaultValue = "0") int lugar_hasta,Authentication auth, Model model,HttpSession session) {
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMINISTRADOR"))) {
			session.setAttribute("SessionRol", "ADMINISTRADOR");
		}
		if(auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("AUDITOR"))) {
			session.setAttribute("SessionRol", "AUDITOR");
		}
		
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.BUSQUEDA_ACTIVOS_ENTRE_FECHAS_Y_LUGARES);
		model.addAttribute("lugares_desde",lugarService.getAll());
		model.addAttribute("lugares_hasta",lugarService.getAll());
		if(desde != null && hasta != null && lugar_desde > 0 && lugar_hasta > 0) {
			logger.info("aca");
			Set<PermisoDiarioModel> permisosDiarios = permisoDiarioService.buscarPermisoDiarioEntreFechasYLugares(desde,hasta,lugar_desde,lugar_hasta);
			if(permisosDiarios.size() > 0) {
				model.addAttribute("permisosDiarios",permisosDiarios);
			}
			Set<PermisoPeriodoModel> permisosPeriodos = permisoPeriodoService.buscarPermisoPeriodosEntreFechasYLugares(desde,hasta,lugar_desde,lugar_hasta);
			logger.info(hasta.toString());
			if(permisosPeriodos.size() > 0) {
				model.addAttribute("permisosPeriodos",permisosPeriodos);
			}
		}
        return mav;
	}
}
