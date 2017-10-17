package com.cas.authority.model;

import java.util.Date;

import javax.persistence.Id;

public class Record {
	/**
	 * 订单编号
	 */
	@Id
	private Integer id;

	/**
	 * 供货时间（作为授权证书中的内容）
	 */
	private Date date_supply;
	/**
	 * 记录的添加时间
	 */
	private Date date_create;

	/**
	 * 产品编号（作为授权证书中的内容）
	 */
	private Integer pid;
	/**
	 * 交易类型("0:押标","1:供货")
	 */
	private Integer type;
	/**
	 * 订单金额(单位：万元)
	 */
	private Float price;
	/**
	 * 销售人员
	 */
	private String sid;

	/**
	 * 客户编号
	 */
	private Integer cid;

	/**
	 * 获取订单编号
	 * @return id - 订单编号
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置订单编号
	 * @param id 订单编号
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取供货时间（作为授权证书中的内容）
	 * @return date - 供货时间（作为授权证书中的内容）
	 */
	public Date getDate_create() {
		return date_create;
	}

	/**
	 * 设置供货时间（作为授权证书中的内容）
	 * @param date 供货时间（作为授权证书中的内容）
	 */
	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}

	/**
	 * 获取供货时间（作为授权证书中的内容）
	 * @return date - 供货时间（作为授权证书中的内容）
	 */
	public Date getDate_supply() {
		return date_supply;
	}

	/**
	 * 设置供货时间（作为授权证书中的内容）
	 * @param date 供货时间（作为授权证书中的内容）
	 */
	public void setDate_supply(Date date_supply) {
		this.date_supply = date_supply;
	}

	/**
	 * 获取产品编号（作为授权证书中的内容）
	 * @return pid - 产品编号（作为授权证书中的内容）
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 设置产品编号（作为授权证书中的内容）
	 * @param pid 产品编号（作为授权证书中的内容）
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 获取交易类型("0:押标","1:供货")
	 * @return type - 交易类型("0:押标","1:供货")
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置交易类型("0:押标","1:供货")
	 * @param type 交易类型("0:押标","1:供货")
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取订单金额(单位：万元)
	 * @return price - 订单金额(单位：万元)
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * 设置订单金额(单位：万元)
	 * @param price 订单金额(单位：万元)
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * 获取销售人员
	 * @return sid - 销售人员
	 */
	public String getSid() {
		return sid;
	}

	/**
	 * 设置销售人员
	 * @param sid 销售人员
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}