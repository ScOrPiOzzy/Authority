package com.cas.authority;

public final class Consts {
	private Consts() {
	}

	public static final String FILE_RECEIPT = "./cas.receipt";
	public static final String FILE_AUTHORITY = "./cas.authority";
	public static final String FILE_CERTIFICATION = "./cas.cer";
	public static final String FILE_KYESTORE = "./cas.keystore";
	public static final String FILE_TIMESTAMP = "./cas.timestamp";
	public static final String FILE_ACCOUNT = "./cas.account";

	/**
	 * 有效的授权文件。
	 */
	public static final int AUTHORITY_FILE_AVAILABLE = 100;
	/**
	 * 未找到授权文件。
	 */
	public static final int AUTHORITY_FILE_NOT_FOUNT = 404;
	/**
	 * 授权文件失效，原因是文件被篡改。
	 */
	public static final int AUTHORITY_FILE_MODIFIED = 500;
	/**
	 * 授权文件失效，原因将软件拷贝到了其它电脑上。
	 */
	public static final int AUTHORITY_FILE_COPY = 503;
	/**
	 * 授权文件失效，原因是过期了。
	 */
	public static final int AUTHORITY_FILE_EXPIRED = 505;
	/**
	 * 授权文件失效，原因是产品与授权产品不匹配。
	 */
	public static final int AUTHORITY_FILE_UNPITCH = 600;

	public static final String BASE_SERVER_URI = "http://192.168.1.42:8080/AuthorityWebservice/rest/authority/";

	public static final String SERVER_URI_REG = "reg";
	public static final String SERVER_URI_VALIDATE = "validate";

}
