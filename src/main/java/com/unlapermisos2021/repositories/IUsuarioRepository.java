package com.unlapermisos2021.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

	public Usuario findById(long idUsusario);
}
