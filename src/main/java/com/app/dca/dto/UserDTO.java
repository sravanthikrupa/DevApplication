package com.app.dca.dto;

public class UserDTO {
	private int userId;
	private String userName;
	private String userType;

	public UserDTO() {
		super();
	}

	public UserDTO(int userId, String userName, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
  
}
