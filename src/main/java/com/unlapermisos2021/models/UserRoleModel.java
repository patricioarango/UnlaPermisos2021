package com.unlapermisos2021.models;

import java.time.LocalDateTime;

public class UserRoleModel {
	private long id;
	private String role;
	private LocalDateTime createdat; 
	private LocalDateTime updatedat;
	private boolean enabled;
	
	public UserRoleModel() {}
	public UserRoleModel(String role) {
		this.setRole(role);
		this.setEnabled(true);
		this.setCreatedat(LocalDateTime.now());
		this.setUpdatedat(LocalDateTime.now());
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

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public LocalDateTime getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(LocalDateTime updatedat) {
		this.updatedat = updatedat;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
}
