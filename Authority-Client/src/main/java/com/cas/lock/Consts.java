package com.cas.lock;

final class Consts {
	private Consts() {
	}

	public static final String AUTHORITY_FILE = "./cas.authority";
	public static final String ACCOUNT_BOOK = "./cas.account";

	/**
	 * 有效的授权文件。
	 */
	public static final Integer AUTHORITY_FILE_AVAILABLE = 100;
	/**
	 * 未找到授权文件。
	 */
	public static final Integer AUTHORITY_FILE_NOT_FOUNT = 404;
	/**
	 * 授权文件失效，原因是文件被篡改。
	 */
	public static final Integer AUTHORITY_FILE_MODIFIED = 500;
	/**
	 * 授权文件失效，原因将软件拷贝到了其它电脑上。
	 */
	public static final Integer AUTHORITY_FILE_COPY = 503;
	/**
	 * 授权文件失效，原因是过期了。
	 */
	public static final Integer AUTHORITY_FILE_EXPIRED = 505;
	/**
	 * 授权文件失效，原因是产品与授权产品不匹配。
	 */
	public static final Integer AUTHORITY_FILE_UNPITCH = 600;

	public static final String BASE_SERVER_URI = "http://localhost:8080/AuthorityWebservice/rest/authority/";
	public static final String SERVER_URI_REG = "reg";
	public static final String SERVER_URI_VALIDATE = "validate";

}
