package com.unlapermisos2021.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.unlapermisos2021.helpers.ViewRoutesHelper;
import com.unlapermisos2021.models.PermisoDiarioModel;
import com.unlapermisos2021.models.PermisoModel;
import com.unlapermisos2021.models.PermisoPeriodoModel;
import com.unlapermisos2021.models.PersonaModel;
import com.unlapermisos2021.models.RodadoModel;
import com.unlapermisos2021.services.ILugarService;
import com.unlapermisos2021.services.IPermisoDiarioService;
import com.unlapermisos2021.services.IPermisoPeriodoService;
import com.unlapermisos2021.services.IPermisoService;
import com.unlapermisos2021.services.IPersonaService;
import com.unlapermisos2021.services.IRodadoService;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;


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
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired 
	private IPermisoService permisoService;
	
	@Autowired 
	private ILugarService lugarService;
	
	@Autowired
	private IRodadoService rodadoService;
	
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
		PermisoDiarioModel permisoDiario = permisoDiarioService.findByIdPermiso(idPermiso);
		StringBuilder link_para_qr = new StringBuilder("https://patricioarango.github.io/permiso_diario.html"); 
		link_para_qr.append("?nombre=" + permisoDiario.getPedido().getNombrePersona());
		link_para_qr.append("&apellido=" + permisoDiario.getPedido().getApellidoPersona());
		link_para_qr.append("&desde=" + permisoDiario.getDesde().getLugar());
		link_para_qr.append("&hasta=" + permisoDiario.getHasta().getLugar());
		link_para_qr.append("&motivo=" + permisoDiario.getMotivo());
		link_para_qr.append("&dni=" + permisoDiario.getPedido().getDniPersona());
		link_para_qr.append("&fecha=" + permisoDiario.getFecha().toString());

		ByteArrayOutputStream bout = QRCode.from(link_para_qr.toString()).to(ImageType.PNG).withSize(250, 250).stream();
		String filename = "qrcodeImg-" + String.valueOf(idPermiso)  + ".png";
		String ruta = "src/main/resources/static/images/";
		String imagenVista = "/images/" + filename;
		String rutacompleta = ruta + filename;
		try {
			File f = new File(rutacompleta);
            OutputStream out = new FileOutputStream(f);
            bout.writeTo(out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		StringBuilder link_para_qr_onthefly = new StringBuilder("/generador_qr?qrText="); 
		String link_encodeado = link_para_qr.toString().replace('?', '@').replace('&', '#');
		link_para_qr_onthefly.append(link_encodeado);
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_VER_DIARIO);
		mav.addObject("permisoDiario", permisoDiario);
        mav.addObject("imagen", imagenVista);
        mav.addObject("link_qr", link_para_qr_onthefly.toString());
        return mav;
	}

	@GetMapping("/permiso/ver_permiso_periodo/{idPermiso}")
	public ModelAndView ver_periodo(@PathVariable int idPermiso, Model model) {
		PermisoPeriodoModel permisoDiario = permisoPeriodoService.findByIdPermiso(idPermiso);
		StringBuilder link_para_qr = new StringBuilder("https://patricioarango.github.io/permiso_periodo.html"); 
		link_para_qr.append("?nombre=" + permisoDiario.getPedido().getNombrePersona());
		link_para_qr.append("&apellido=" + permisoDiario.getPedido().getApellidoPersona());
		link_para_qr.append("&desde=" + permisoDiario.getDesde().getLugar());
		link_para_qr.append("&hasta=" + permisoDiario.getHasta().getLugar());
		link_para_qr.append("&fecha_inicio=" + permisoDiario.getFecha().toString());
		link_para_qr.append("&fecha_fin=" + permisoDiario.getFecha().plusDays(permisoDiario.getCantDias() -1).toString());
		link_para_qr.append("&dni=" + permisoDiario.getPedido().getDniPersona());
		link_para_qr.append("&vehiculo=" + permisoDiario.getRodado().getVehiculo());
		link_para_qr.append("&dominio=" + permisoDiario.getRodado().getDominio());

		ByteArrayOutputStream bout = QRCode.from(link_para_qr.toString()).to(ImageType.PNG).withSize(250, 250).stream();
		String filename = "qrcodeImg-" + String.valueOf(idPermiso)  + ".png";
		String ruta = "src/main/resources/static/images/";
		String imagenVista = "/images/" + filename;
		String rutacompleta = ruta + filename;
		try {
			File f = new File(rutacompleta);
            OutputStream out = new FileOutputStream(f);
            bout.writeTo(out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }		
		StringBuilder link_para_qr_onthefly = new StringBuilder("/generador_qr?qrText="); 
		String link_encodeado = link_para_qr.toString().replace('?', '@').replace('&', '#');
		link_para_qr_onthefly.append(link_encodeado);
		ModelAndView mav = new ModelAndView(ViewRoutesHelper.PERMISO_VER_PERIODO);
        mav.addObject("permisoPeriodo", permisoDiario);
        mav.addObject("imagen", imagenVista);
        mav.addObject("link_qr", link_para_qr_onthefly.toString());
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
			Set<PermisoPeriodoModel> permisosPeriodos = permisoPeriodoService.buscarPermisoPeriodosActivosPorIdPersona(personaDB.getIdPersona());
			if(permisosPeriodos.size() > 0) {
				model.addAttribute("permisosPeriodos",permisosPeriodos);
			}
		} 
		return mav;
	}
	
	@GetMapping("/permiso/nuevo/{idPersona}")
	public ModelAndView nuevo(@PathVariable int idPersona, Model model) {
		ModelAndView mav;
		PersonaModel persona =  personaService.findByIdPersona(idPersona);
		if(persona == null) mav = new ModelAndView();
		mav = new ModelAndView(ViewRoutesHelper.PERMISO_NUEVO);
		mav.addObject("persona", persona);
		model.addAttribute("desde", lugarService.getAll());
		model.addAttribute("hasta", lugarService.getAll());
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
		
		PersonaModel personaGuardada = personaService.guardar(persona);
		mav.addObject("persona", personaGuardada);
		model.addAttribute("desde", lugarService.getAll());
		model.addAttribute("hasta", lugarService.getAll());
		return mav;
	}
	
	@RequestMapping(value = "/permiso/guardar", method = RequestMethod.POST,params="action=permisoDiario")
	public ModelAndView guardar(Model model,@ModelAttribute("persona") PersonaModel persona,@RequestParam(required = true) int desde,@RequestParam(required = true) int hasta,@RequestParam("fecha") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fecha) {
		ModelAndView mav;
		//chequeamos la persona, si no existe, afuera
		PersonaModel personaDB =  personaService.findByIdPersona(persona.getIdPersona());
		if(personaDB == null) mav = new ModelAndView();
		mav = new ModelAndView(ViewRoutesHelper.PERMISO_NUEVO_DIARIO);
		PermisoModel permiso = new PermisoModel();
		permiso.setDesde(lugarService.findByIdLugar(desde));
		permiso.setHasta(lugarService.findByIdLugar(hasta));
		permiso.setFecha(fecha);
		permiso.setPedido(personaDB);
		PermisoModel permisoDB = permisoService.guardar(permiso);
		mav.addObject("persona", persona);
		mav.addObject("permiso", permisoDB);
        return mav;
	}
	
	@PostMapping("/permiso/guardar_permiso_diario")
	public String guardar_permiso_diario(@ModelAttribute("permiso") PermisoModel permiso,@ModelAttribute("permisoDiario") PermisoDiarioModel permisoDiario,@ModelAttribute("persona") PersonaModel persona) {
		//chequeamos la persona, si no existe, afuera
		PersonaModel personaDB =  personaService.findByIdPersona(persona.getIdPersona());
		if(personaDB == null) return "redirect:/permiso/nuevo/" + persona.getIdPersona();
		
		PermisoModel permisoDB = permisoService.getByIdPermiso(permiso.getIdPermiso());
		if(permisoDB == null) return "redirect:/permiso/nuevo/" + persona.getIdPersona();
		permisoDiario.setPedido(personaDB);
		permisoDiario.setDesde(permisoDB.getDesde());
		permisoDiario.setHasta(permisoDB.getHasta());
		permisoDiario.setFecha(permisoDB.getFecha());
		PermisoDiarioModel permisoDF = permisoDiarioService.guardar(permisoDiario);
		return "redirect:/permiso/ver_permiso_diario/" + permisoDF.getIdPermiso();
	}
	
	@RequestMapping(value = "/permiso/guardar", method = RequestMethod.POST,params="action=permisoPeriodo")
	public ModelAndView guardarPeriodo(Model model,@ModelAttribute("persona") PersonaModel persona,@RequestParam(required = true) int desde,@RequestParam(required = true) int hasta,@RequestParam("fecha") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fecha) {
		ModelAndView mav;
		//chequeamos la persona, si no existe, afuera
		PersonaModel personaDB =  personaService.findByIdPersona(persona.getIdPersona());
		if(personaDB == null) mav = new ModelAndView();
		mav = new ModelAndView(ViewRoutesHelper.PERMISO_NUEVO_PERIODO);
		PermisoModel permiso = new PermisoModel();
		permiso.setDesde(lugarService.findByIdLugar(desde));
		permiso.setHasta(lugarService.findByIdLugar(hasta));
		permiso.setFecha(fecha);
		permiso.setPedido(personaDB);
		PermisoModel permisoDB = permisoService.guardar(permiso);
		mav.addObject("persona", persona);
		mav.addObject("permiso", permisoDB);
        return mav;
	}
	
	@PostMapping("/permiso/guardar_permiso_periodo")
	public String guardar_permiso_periodo(@ModelAttribute("permiso") PermisoModel permiso,@ModelAttribute("permisoPeriodo") PermisoPeriodoModel permisoPeriodo,@ModelAttribute("persona") PersonaModel persona,@ModelAttribute("rodado") RodadoModel rodado) {
		//chequeamos la persona, si no existe, afuera
		PersonaModel personaDB =  personaService.findByIdPersona(persona.getIdPersona());
		if(personaDB == null) return "redirect:/permiso/nuevo/" + persona.getIdPersona();
		
		PermisoModel permisoDB = permisoService.getByIdPermiso(permiso.getIdPermiso());
		if(permisoDB == null) return "redirect:/permiso/nuevo/" + persona.getIdPersona();
		logger.info(rodado.toString());
		RodadoModel rodadoDB = rodadoService.guardar(rodado);
		permisoPeriodo.setPedido(personaDB);
		permisoPeriodo.setRodado(rodadoDB);
		permisoPeriodo.setDesde(permisoDB.getDesde());
		permisoPeriodo.setHasta(permisoDB.getHasta());
		permisoPeriodo.setFecha(permisoDB.getFecha());
		PermisoPeriodoModel permisoDF = permisoPeriodoService.guardar(permisoPeriodo);
		return "redirect:/permiso/ver_permiso_periodo/" + permisoDF.getIdPermiso();
	}
}
