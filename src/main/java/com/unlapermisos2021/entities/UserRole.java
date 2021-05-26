package com.unlapermisos2021.entities;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = { "id"}))
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "role", nullable = false, length = 100)
	private String role;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy="rol")  
	private Set<Usuario> usuarios;
	
	public UserRole() {
	}

	public UserRole(long Id, String role,boolean enabled) {
		this.setId(Id);
		this.setRole(role);
		this.setEnabled(enabled);
		this.setUpdatedAt(LocalDateTime.now());
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}