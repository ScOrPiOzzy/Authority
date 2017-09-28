package com.cas.authority.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7922267193879315191L;

	private Integer id;
	@NotNull(message = "{user.unit.notnull.error}")
	private String unit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
