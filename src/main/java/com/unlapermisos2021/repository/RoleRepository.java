package com.unlapermisos2021.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.UserRole;

@Repository
public interface RoleRepository extends CrudRepository <UserRole,Long>{

}
