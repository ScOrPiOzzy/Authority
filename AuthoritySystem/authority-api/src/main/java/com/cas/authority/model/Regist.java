package com.cas.authority.model;

import java.util.Date;

import javax.persistence.Id;

public class Regist {
//	
	@Id
	private Integer id;
//	注册码
	private String code;
//	节点数
	private Integer node;
//	硬盘序列号
	private String ser_hdd;
//	处理器序列号
	private String ser_cpu;
//	有效期起始日期
	private Date date_start;
//	过期日期
	private Date date_end;
//	过期日期
	private Integer record_id;
	
	private Integer used;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNode() {
		return node;
	}

	public void setNode(Integer node) {
		this.node = node;
	}

	public String getSer_hdd() {
		return ser_hdd;
	}

	public void setSer_hdd(String ser_hdd) {
		this.ser_hdd = ser_hdd;
	}

	public String getSer_cpu() {
		return ser_cpu;
	}

	public void setSer_cpu(String ser_cpu) {
		this.ser_cpu = ser_cpu;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public Integer getRecord_id() {
		return record_id;
	}

	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

}
