package com.cas.authority.model;

public class UserRegistEntity {
	private String username;
	private String registCode;
	private Integer registId;
	private Integer registUsed;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRegistCode() {
		return registCode;
	}

	public void setRegistCode(String registCode) {
		this.registCode = registCode;
	}

	public Integer getRegistId() {
		return registId;
	}

	public void setRegistId(Integer registId) {
		this.registId = registId;
	}

	public Integer getRegistUsed() {
		return registUsed;
	}

	public void setRegistUsed(Integer registUsed) {
		this.registUsed = registUsed;
	}

}
