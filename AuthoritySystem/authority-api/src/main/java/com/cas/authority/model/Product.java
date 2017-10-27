package com.cas.authority.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	/**
	 * 产品ID
	 */
	@Id
	private String id;
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releasedate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	public Date getReleasedate() {
		return releasedate;
	}

	/**
	 * 设置发布时间
	 * @param releasedate 发布时间
	 */
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
}