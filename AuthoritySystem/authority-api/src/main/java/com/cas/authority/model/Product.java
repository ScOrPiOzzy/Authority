package com.cas.authority.model;

public class Product {
	/**
	 * 产品ID
	 */
	private Integer id;

	/**
	 * 产品版本
	 */
	private String version;

	/**
	 * 产品名称
	 */
	private String name;

	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 发布时间
	 */
	private String releasedate;

	/**
	 * 获取产品ID
	 * @return id - 产品ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置产品ID
	 * @param id 产品ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取产品版本
	 * @return version - 产品版本
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 设置产品版本
	 * @param version 产品版本
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * 获取产品名称
	 * @return name - 产品名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置产品名称
	 * @param name 产品名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取备注信息
	 * @return remark - 备注信息
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注信息
	 * @param remark 备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取发布时间
	 * @return releaseDate - 发布时间
	 */
	public String getReleasedate() {
		return releasedate;
	}

	/**
	 * 设置发布时间
	 * @param releasedate 发布时间
	 */
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
}