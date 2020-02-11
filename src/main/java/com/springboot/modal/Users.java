package com.springboot.modal;

import javax.persistence.Entity;

public class Users {
	
	String username;
	String password;
	boolean enabled;
	String phone;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String password, boolean enabled, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
