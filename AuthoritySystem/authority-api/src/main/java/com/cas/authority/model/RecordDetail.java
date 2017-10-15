package com.cas.authority.model;

import java.util.Date;

public class RecordDetail {
	/**
	 * 订单编号
	 */
	private Integer id;

	/**
	 * 供货时间（作为授权证书中的内容）
	 */
	private Date date;

	/**
	 * 客户名称
	 */
	private String username;

	/**
	 * 产品名称（作为授权证书中的内容）
	 */
	private String productName;

	/**
	 * 订单金额(单位：万元)
	 */
	private Float price;

	/**
	 * 剩余欠款
	 */
	private Float debt;

	/**
	 * 销售人员
	 */
	private String salerName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDebt() {
		return debt;
	}

	public void setDebt(Float debt) {
		this.debt = debt;
	}

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}

}
