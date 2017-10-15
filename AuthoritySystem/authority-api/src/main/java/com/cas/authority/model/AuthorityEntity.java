package com.cas.authority.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthorityEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8388545476374249262L;
	// 公司名称
	private String companyName;
	// 客户名称
	@NotNull(message = "{regist.customName.notnull.error}")
	private String customName;
	// 注册码
	@NotNull(message = "{regist.code.notnull.error}")
	private String code;

	// （系统盘）硬盘序列号
	private String hddSer;
	// 处理器序列号
	private String cpuSer;
	// 产品代号
	private String productID;
	// 过期时间(格式：yyyy-MM-dd)
	private String fromDate;
	// 过期时间(格式：yyyy-MM-dd)
	private String endDate;
	// 数字签名
	private String sign;
	// 软件客户端节点数
	private int node;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getHddSer() {
		return hddSer;
	}

	public void setHddSer(String hddSer) {
		this.hddSer = hddSer;
	}

	public String getCpuSer() {
		return cpuSer;
	}

	public void setCpuSer(String cpuSer) {
		this.cpuSer = cpuSer;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "\r\n---开始授权证书信息---\r\n" + //
				"公司名称： " + companyName + " \r\n" + //
				"客户名称： " + customName + " \r\n" + //
				"产品代码： " + productID + " \r\n" + //
				"注册码： " + code + " \r\n" + //
				"节点数： " + node + " \r\n" + //
				"系统盘序列号： " + hddSer + " \r\n" + //
				"处理器序列号： " + cpuSer + " \r\n" + //
				"起始日期： " + fromDate + " \r\n" + //
				"失效日期： " + endDate + " \r\n" + //
				"---结束授权证书信息---";//
	}

}
