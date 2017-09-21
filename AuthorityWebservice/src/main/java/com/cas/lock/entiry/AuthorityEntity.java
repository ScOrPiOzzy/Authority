package com.cas.lock.entiry;

public class AuthorityEntity {
	// 注册码
	private String regCode;
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

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "\r\n---开始授权证书信息---\r\n" + //
				"注册码： " + regCode + " \r\n"//
				+ "系统盘序列号： " + hddSer + " \r\n" //
				+ "处理器序列号： " + cpuSer + " \r\n" //
				+ "产品代码： " + productID + " \r\n" //
				+ "起始日期： " + fromDate + " \r\n" //
				+ "失效日期： " + endDate + " \r\n"//
				+ "---结束授权证书信息---";//
	}

}
