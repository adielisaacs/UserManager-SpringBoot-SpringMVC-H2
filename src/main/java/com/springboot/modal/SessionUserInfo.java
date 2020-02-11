package com.springboot.modal;

import java.util.Date;

public class SessionUserInfo {
	String user;
	String token;
	Integer validAmount;
	Date logintime;
	
	public SessionUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SessionUserInfo(String user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getValidAmount() {
		return validAmount;
	}
	public void setValidAmount(Integer validAmount) {
		this.validAmount = validAmount;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(long logintime) {
		this.logintime = new Date(logintime);
	}
	
}
