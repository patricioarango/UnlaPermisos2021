package com.unlapermisos2021.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.Lugar;

@Repository
public interface ILugarRepository extends JpaRepository<Lugar, Serializable>{

	public Lugar findByIdLugar(int idLugar);
}
