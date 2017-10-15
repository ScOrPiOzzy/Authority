package com.cas.authority.model;

public class Record {
	/**
	 * 订单编号
	 */
	private Integer id;

	/**
	 * 供货时间（作为授权证书中的内容）
	 */
	private String date;

	/**
	 * 客户编号
	 */
	private Integer cid;

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
	 * 加密锁
	 */
	private String eid;

	/**
	 * 剩余欠款
	 */
	private Float debt;

	/**
	 * 销售人员
	 */
	private String sid;

	/**
	 * 一个产品对于一个客户都有一个唯一的注册码
	 */
	private String rcode;

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
	public String getDate() {
		return date;
	}

	/**
	 * 设置供货时间（作为授权证书中的内容）
	 * @param date 供货时间（作为授权证书中的内容）
	 */
	public void setDate(String date) {
		this.date = date;
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
	 * 获取加密锁
	 * @return eid - 加密锁
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 设置加密锁
	 * @param eid 加密锁
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 获取剩余欠款
	 * @return debt - 剩余欠款
	 */
	public Float getDebt() {
		return debt;
	}

	/**
	 * 设置剩余欠款
	 * @param debt 剩余欠款
	 */
	public void setDebt(Float debt) {
		this.debt = debt;
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

	/**
	 * 获取一个产品对于一个客户都有一个唯一的注册码
	 * @return rcode - 一个产品对于一个客户都有一个唯一的注册码
	 */
	public String getRcode() {
		return rcode;
	}

	/**
	 * 设置一个产品对于一个客户都有一个唯一的注册码
	 * @param rcode 一个产品对于一个客户都有一个唯一的注册码
	 */
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}