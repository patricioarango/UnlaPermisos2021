package com.unlapermisos2021.util;

import java.util.List;
import java.util.Map;

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
import com.unlapermisos2021.models.UserRoleModel;

@Component("/roles/listado_roles")
public class listarRolesPdf extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		@SuppressWarnings("unchecked")
		List<UserRoleModel> listaRoles = (List<UserRoleModel>) model.get("roles");
		
		document.setPageSize(PageSize.A4.rotate());
		document.open();
		
		PdfPTable titulo = new PdfPTable(1);
		PdfPCell celda=null;
		Font fuenteTitulo = FontFactory.getFont("Arial",18);
		
		celda = new PdfPCell(new Phrase("Listado de Roles",fuenteTitulo));
		celda.setBorder(0);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo.addCell(celda);
		titulo.setSpacingAfter(30);
		PdfPTable headers = new PdfPTable(2);
		headers.addCell("idRol");
		headers.addCell("Nombre Rol");
		PdfPTable tablaUsuarios = new PdfPTable(2);
		listaRoles.forEach(rol ->{
			tablaUsuarios.addCell(String.valueOf(rol.getId()));
			tablaUsuarios.addCell(rol.getRole());
		});
		
		document.add(titulo);
		document.add(headers);
		document.add(tablaUsuarios);
	}
}
