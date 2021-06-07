package com.unlapermisos2021.services;

import java.util.Set;

import com.unlapermisos2021.models.LugarModel;

public interface ILugarService {

	public LugarModel guardar(LugarModel lugar);

	public Set<LugarModel> getAll();
	public LugarModel findByIdLugar(int id);
}
