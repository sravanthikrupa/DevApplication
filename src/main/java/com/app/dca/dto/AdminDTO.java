package com.app.dca.dto;

public class AdminDTO {
	private int adminId;
	private String adminName;

	public AdminDTO() {
		super();
	}

	public AdminDTO(int adminId, String adminName) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


}
