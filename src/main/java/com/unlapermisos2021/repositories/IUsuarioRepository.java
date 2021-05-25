package com.unlapermisos2021.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unlapermisos2021.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

	public Usuario findById(long idUsusario);
	
	public Usuario findByUsername(String Username);
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.rol WHERE u.username = (:username)")
	public abstract Usuario findByUsernameAndFetchPerfilEagerly(@Param("username") String username);
}
