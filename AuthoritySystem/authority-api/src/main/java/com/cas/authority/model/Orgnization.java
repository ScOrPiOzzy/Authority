package com.cas.authority.model;

public class Orgnization {
	private Integer id;

	private String name;

	/**
	 * 地址
	 */
	private String address;

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
	 * 获取地址
	 * @return address - 地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置地址
	 * @param address 地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}