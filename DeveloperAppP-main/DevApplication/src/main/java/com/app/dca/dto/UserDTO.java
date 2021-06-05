package com.app.dca.dto;

public class UserDTO {
  String userId;
  String password;
  String role;
public UserDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public UserDTO(String userId, String password, String role) {
	super();
	this.userId = userId;
	this.password = password;
	this.role = role;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
  
}
