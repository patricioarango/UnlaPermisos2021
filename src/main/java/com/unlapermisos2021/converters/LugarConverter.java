package com.unlapermisos2021.converters;

import org.springframework.stereotype.Component;

import com.unlapermisos2021.entities.Lugar;
import com.unlapermisos2021.models.LugarModel;

@Component("lugarConverter")
public class LugarConverter {

	public Lugar modelToEntity(LugarModel lugarModel) {
		return new Lugar(lugarModel.getIdLugar(), lugarModel.getLugar(), lugarModel.getCodigoPostal());
	}

	public LugarModel entityToModel(Lugar lugar) {
		return new LugarModel(lugar.getIdLugar(), lugar.getLugar(), lugar.getCodigoPostal());
	}
}	