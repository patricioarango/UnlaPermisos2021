package com.unlapermisos2021.converters;

import org.springframework.stereotype.Component;

import com.unlapermisos2021.entities.Rodado;
import com.unlapermisos2021.models.RodadoModel;

@Component
public class RodadoConverter {

	public RodadoModel entityToModel(Rodado rodado) {
		return new RodadoModel(rodado.getIdRodado(),rodado.getDominio(),rodado.getVehiculo());
	}

	public Rodado modelToEntity(RodadoModel rodado) {
		return new Rodado(rodado.getIdRodado(),rodado.getDominio(),rodado.getVehiculo());
	}
}