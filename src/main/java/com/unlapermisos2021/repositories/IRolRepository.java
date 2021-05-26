package com.unlapermisos2021.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.UserRole;

@Repository
public interface IRolRepository extends JpaRepository<UserRole, Serializable> {

	public UserRole findById(long id);
	public List<UserRole> findAllByEnabledTrue();
}
