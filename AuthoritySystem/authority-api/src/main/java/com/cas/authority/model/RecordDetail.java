package com.cas.authority.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class RecordDetail {
	/**
	 * 订单编号
	 */
	@Id
	private Integer id;

	/**
	 * 供货时间（作为授权证书中的内容）
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	/**
	 * 供货时间（作为授权证书中的内容）
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date supplyDate;

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
	 * 销售人员
	 */
	private String salerName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getSupplyDate() {
		return supplyDate;
	}

	public void setSupplyDate(Date supplyDate) {
		this.supplyDate = supplyDate;
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

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}

}
