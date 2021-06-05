package com.unlapermisos2021.controllers;

import java.time.LocalDate;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.LugarModel;
import com.unlapermisos2021.models.PermisoDiarioModel;
import com.unlapermisos2021.models.PermisoModel;
import com.unlapermisos2021.models.PersonaModel;
import com.unlapermisos2021.services.IPermisoDiarioService;
import com.unlapermisos2021.services.IPermisoService;
import com.unlapermisos2021.services.IPersonaService;


@Controller
@RequestMapping("/")
public class PermisoController {
	Logger logger = LoggerFactory.getLogger(PermisoController.class);
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicial;
	
	@Autowired 
	private IPersonaService personaService;
	
	@Autowired 
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired 
	private IPermisoService permisoService;
	
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

	@GetMapping("/permiso/ver_permiso_diario/{idPermiso}")
	public ModelAndView ver(@PathVariable int idPermiso, Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_VER);
		PersonaModel persona =  new PersonaModel();
        mav.addObject("persona", persona);
        return mav;
	}

	@PostMapping("/permiso/verificar_dni")
	public ModelAndView verificar_dni(Model model,@ModelAttribute("persona") PersonaModel persona) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_LLENAR_PERSONA); 
		mav.addObject("persona", persona);
		//existe la persona?
		PersonaModel personaDB = personaService.findByDniPersona(persona.getDniPersona());
		if(personaDB.getIdPersona() > 0) {
			mav = new ModelAndView(ViewRoutesHelper.PERMISO_PERSONA_EXISTE); 
			mav.addObject("persona", personaDB);
			//tiene permisos activos?
			//primero buscamos en permisos diarios por fecha de hoy
			Set<PermisoDiarioModel> permisosDiarios = permisoDiarioService.buscarPermisoDiarioActivoPorIdPersona(personaDB.getIdPersona());
			if(permisosDiarios.size() > 0) {
				model.addAttribute("permisosDiarios",permisosDiarios);
			}
		} 
		return mav;
	}
	
	@GetMapping("/permiso/ingresar_persona")
	public ModelAndView ingresar_persona(Model model) {
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_LLENAR_PERSONA);
		return mav;
	}

	@PostMapping("/permiso/guardar_persona")
	public ModelAndView guardar_persona(Model model,@ModelAttribute("persona") PersonaModel persona) {
		//volvemos a chequear si el dni existe
		PersonaModel personaDB = personaService.findByDniPersona(persona.getDniPersona());
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_NUEVO);
			if(personaDB.getIdPersona() > 0) mav = new ModelAndView();
		
		personaService.guardar(persona);
		mav.addObject("persona", persona);
		LocalDate fechaPrevia = LocalDate.now();
		PermisoModel permiso = new PermisoModel(persona,fechaPrevia);
		PermisoModel permisoDB = permisoService.guardar(permiso);
		mav.addObject("permiso", permisoDB);
		LugarModel desde = new LugarModel();
        LugarModel hasta = new LugarModel();
        model.addAttribute("desde", desde);
        model.addAttribute("hasta", hasta);
		return mav;
	}
	
	@GetMapping("/permiso/nuevo/{idPersona}")
	public ModelAndView nuevo(@PathVariable int idPersona, Model model) {
		ModelAndView mav;
		PersonaModel persona =  personaService.findByIdPersona(idPersona);
		if(persona == null) mav = new ModelAndView();
		mav = new ModelAndView(ViewRoutesHelper.PERMISO_NUEVO);
		LocalDate fechaPrevia = LocalDate.now();
		PermisoModel permiso = new PermisoModel(persona,fechaPrevia);
		PermisoModel permisoDB = permisoService.guardar(permiso);
		logger.info(String.valueOf(permisoDB.getIdPermiso()));
		mav.addObject("permiso", permisoDB);
		LugarModel desde = new LugarModel();
		LugarModel hasta = new LugarModel();
        model.addAttribute("desde", desde);
        model.addAttribute("hasta", hasta);
        return mav;
	}
	
	@RequestMapping(value = "/permiso/guardar", method = RequestMethod.POST,params="action=permisoDiario")
	public ModelAndView permisoDiario(Model model,@ModelAttribute("desde") LugarModel desde,@ModelAttribute("hasta") LugarModel hasta,@ModelAttribute("permiso") PermisoModel permiso) {
		PermisoModel permisoM = permisoService.findById(permiso.getIdPermiso());
		PermisoModel permisoDB = permisoService.guardar(permiso);
		//permisoDiarioService.guardar(permisoDiario);
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_NUEVO_DIARIO);
		mav.addObject("permisoDiario", permisoDB);
        return mav;
	}
	
	@PostMapping("/permiso/guardar_permiso_diario")
	public String permisoDiario(@ModelAttribute("permisoDiario") PermisoModel permisoDiario) {
		logger.info(String.valueOf(permisoDiario.getIdPermiso()));
		
		//PermisoDiarioModel permisoDB = permisoDiarioService.traerPorId(6);
		/*PermisoDiarioModel permisoDiario = new PermisoDiarioModel();
		permisoDiario.setLugares(permiso.getLugares());
		permisoDiario.setPedido(permiso.getPedido());
		LocalDate fecha = LocalDate.of(2021,06,05);
		permisoDiario.setFecha(fecha);
		PermisoDiarioModel permisoDB = permisoDiarioService.guardar(permisoDiario);*/
		return "redirect:/permisos/ver/" + permisoDiario.getIdPermiso();
		
	}
	
	@RequestMapping(value = "/permiso/guardar_permiso_periodo", method = RequestMethod.POST, params = "permisoPeriodo")
	public ModelAndView permisoPeriodo(Model model) {
		
		ModelAndView mav = new ModelAndView();
        return mav;
	}
}
