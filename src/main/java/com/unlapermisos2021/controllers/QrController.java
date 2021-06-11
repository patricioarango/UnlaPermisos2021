package com.unlapermisos2021.controllers;

import java.awt.image.BufferedImage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.unlapermisos2021.models.PermisoDiarioModel;
import com.unlapermisos2021.models.PermisoPeriodoModel;
import com.unlapermisos2021.services.IPermisoDiarioService;
import com.unlapermisos2021.services.IPermisoPeriodoService;

@RestController
@RequestMapping("/generador_qr")
public class QrController {
	
	Logger logger = LoggerFactory.getLogger(PermisoController.class);
	
	@Autowired 
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired 
	private IPermisoPeriodoService permisoPeriodoService;
	
	@GetMapping(value="/original",produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage generateQRCodeImage(@RequestParam String qrText) throws Exception {
		String cambiado = qrText.toString().replace('@', '?').replace('#', '&');
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(cambiado, BarcodeFormat.QR_CODE, 250, 250);

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@GetMapping(value="/qr_permiso_diario/{idPermiso}",produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage qr_permiso_diario(@PathVariable int idPermiso) throws Exception {
		PermisoDiarioModel permisoDiario = permisoDiarioService.findByIdPermiso(idPermiso);
		StringBuilder link_para_qr = new StringBuilder("https://patricioarango.github.io/permiso_diario.html"); 
		link_para_qr.append("?nombre=" + permisoDiario.getPedido().getNombrePersona());
		link_para_qr.append("&apellido=" + permisoDiario.getPedido().getApellidoPersona());
		link_para_qr.append("&desde=" + permisoDiario.getDesde().getLugar());
		link_para_qr.append("&hasta=" + permisoDiario.getHasta().getLugar());
		link_para_qr.append("&motivo=" + permisoDiario.getMotivo());
		link_para_qr.append("&dni=" + permisoDiario.getPedido().getDniPersona());
		link_para_qr.append("&fecha=" + permisoDiario.getFecha().toString());
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(link_para_qr.toString(), BarcodeFormat.QR_CODE, 250, 250);
		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	@GetMapping(value="/qr_permiso_periodo/{idPermiso}",produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage qr_permiso_periodo(@PathVariable int idPermiso) throws Exception {
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
		link_para_qr.append("&cantdias=" + permisoDiario.getCantDias());
		String vacaciones = (permisoDiario.isVacaciones()) ? "SI" : "NO";
		link_para_qr.append("&vacaciones=" + vacaciones);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(link_para_qr.toString(), BarcodeFormat.QR_CODE, 250, 250);
		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
}
