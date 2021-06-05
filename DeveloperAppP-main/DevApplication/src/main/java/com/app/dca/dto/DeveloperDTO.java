package com.app.dca.dto;

import java.time.LocalDate;

public class DeveloperDTO {
//response template
	int devId;
	String devName;
	String email;
	String skillLevel;
	LocalDate memberSince;
	int reputation;
	boolean isVerified;
	boolean isBlocked;
	
	public DeveloperDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DeveloperDTO(int devId, String devName, String email, String skillLevel, LocalDate memberSince,
			int reputation, boolean isVerified, boolean isBlocked) {
		super();
		this.devId = devId;
		this.devName = devName;
		this.email = email;
		this.skillLevel = skillLevel;
		this.memberSince = memberSince;
		this.reputation = reputation;
		this.isVerified = isVerified;
		this.isBlocked = isBlocked;
	}



	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public LocalDate getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	
}
