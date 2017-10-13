package com.cas.authority.model;

import java.util.Date;
import javax.persistence.*;

public class Edog {
	private String id;

	/**
	 * 加密锁序列号。（唯一标识）
	 */
	private String serial;

	/**
	 * 节点数（支持最大连接的客户端数量）
	 */
	private Integer node;

	/**
	 * 声效日期
	 */
	private Date createtime;

	/**
	 * 有效期结束时间
	 */
	private Date enddate;

	/**
	 * 加密锁的标签（数字）
	 */
	private String label;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取加密锁序列号。（唯一标识）
	 * @return serial - 加密锁序列号。（唯一标识）
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * 设置加密锁序列号。（唯一标识）
	 * @param serial 加密锁序列号。（唯一标识）
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * 获取节点数（支持最大连接的客户端数量）
	 * @return node - 节点数（支持最大连接的客户端数量）
	 */
	public Integer getNode() {
		return node;
	}

	/**
	 * 设置节点数（支持最大连接的客户端数量）
	 * @param node 节点数（支持最大连接的客户端数量）
	 */
	public void setNode(Integer node) {
		this.node = node;
	}

	/**
	 * 获取声效日期
	 * @return createTime - 声效日期
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 设置声效日期
	 * @param createtime 声效日期
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取有效期结束时间
	 * @return endDate - 有效期结束时间
	 */
	public Date getEnddate() {
		return enddate;
	}

	/**
	 * 设置有效期结束时间
	 * @param enddate 有效期结束时间
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	/**
	 * 获取加密锁的标签（数字）
	 * @return label - 加密锁的标签（数字）
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 设置加密锁的标签（数字）
	 * @param label 加密锁的标签（数字）
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}