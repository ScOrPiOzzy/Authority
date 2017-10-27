package com.cas.authority.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.codec.digest.DigestUtils;

import com.cas.authority.model.AuthorityEntity;

public final class EntityUtil {
	public static final String SPLIT_STR = ":";

	private EntityUtil() {
	}

	public static AuthorityEntity parseEntity(InputStream inputStream) {
		AuthorityEntity entity = new AuthorityEntity();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			// 公司名称
			entity.setCompanyName(br.readLine().split(SPLIT_STR)[1]);
			// 客户名称
			entity.setCustomName(br.readLine().split(SPLIT_STR)[1]);
			// 产品注册码
			entity.setCode(br.readLine().split(SPLIT_STR)[1]);
			// 产品代号
			entity.setProductID(br.readLine().split(SPLIT_STR)[1]);
			// 生产日期
			entity.setFromDate(br.readLine().split(SPLIT_STR)[1]);
			// 结束日期
			entity.setEndDate(br.readLine().split(SPLIT_STR)[1]);
			// 节点数
			entity.setNode(Integer.parseInt(br.readLine().split(SPLIT_STR)[1]));
			// 硬件A序列号
			entity.setHddSer(br.readLine().split(SPLIT_STR)[1]);
			// 硬件B序列号
			entity.setCpuSer(br.readLine().split(SPLIT_STR)[1]);
			// 数字签名
			entity.setSign(br.readLine().split(SPLIT_STR)[1]);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return entity;
	}

	public static void saveEntity(AuthorityEntity entity, OutputStream outputStream) {
		// 4-1、保存证书
		PrintWriter out = new PrintWriter(outputStream);
		// 证书基本内容
		out.println("COMPANY" + SPLIT_STR + entity.getCompanyName());
		out.println("User" + SPLIT_STR + entity.getCustomName());
		out.println("REGISTER" + SPLIT_STR + entity.getCode());
		out.println("PRODUCT" + SPLIT_STR + entity.getProductID());
		out.println("GENERATION DATE" + SPLIT_STR + entity.getFromDate());
		out.println("EXPIRATION DATE" + SPLIT_STR + entity.getEndDate());
		out.println("MAX CLIENT" + SPLIT_STR + entity.getNode());
		// sig-a:
		out.println("SIGN-A" + SPLIT_STR + entity.getHddSer());
		// sig-b:
		out.println("SIGN-B" + SPLIT_STR + entity.getCpuSer());
		// sig-c:
		out.println("SIGN-C" + SPLIT_STR + DigestUtils.sha256Hex(entity.toString()));

		out.flush();
	}
}
