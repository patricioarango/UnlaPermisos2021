package com.unlapermisos2021.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.Rodado;

@Repository
public interface IRodadoRepository extends JpaRepository<Rodado, Serializable>{

}
