package com.unlapermisos2021.util;

import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.PdfWriter;
import com.unlapermisos2021.models.UsuarioModel;

@Component("/usuarios/listado_usuarios")

public class listarUsuariosPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		@SuppressWarnings("unchecked")
		List<UsuarioModel> listaUsuarios = (List<UsuarioModel>) model.get("usuarios");
		
		document.setPageSize(PageSize.A4.rotate());
		document.open();
		
		PdfPTable titulo = new PdfPTable(1);
		PdfPCell celda=null;
		Font fuenteTitulo = FontFactory.getFont("Arial",18);
		
		celda = new PdfPCell(new Phrase("Listado de Usuarios",fuenteTitulo));
		celda.setBorder(0);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo.addCell(celda);
		titulo.setSpacingAfter(30);
		PdfPTable headers = new PdfPTable(6);
		headers.addCell("NOMBRE");
		headers.addCell("APELLIDO");
		headers.addCell("NRO_DOCUMENTO");
		headers.addCell("USUARIO");
		headers.addCell("EMAIL");
		headers.addCell("ROL");
		PdfPTable tablaUsuarios = new PdfPTable(6);
		listaUsuarios.forEach(usuario ->{
			tablaUsuarios.addCell(usuario.getNombre());
			tablaUsuarios.addCell(usuario.getApellido());
			tablaUsuarios.addCell(usuario.getNro_documento());
			tablaUsuarios.addCell(usuario.getUsername());
			tablaUsuarios.addCell(usuario.getEmail());
			tablaUsuarios.addCell(usuario.getRol().getRole());
		});
		
		document.add(titulo);
		document.add(headers);
		document.add(tablaUsuarios);
	}
	
}