package com.cas.authority.model;

import javax.persistence.Id;

public class User {
	@Id
	private Integer id;

	private String name;

	private String qq;

	private String weixin;

	private String mobile;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return weixin
	 */
	public String getWeixin() {
		return weixin;
	}

	/**
	 * @param weixin
	 */
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	/**
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}