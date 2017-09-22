package com.cas.lock;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.codec.digest.DigestUtils;

import com.cas.lock.entiry.AuthorityEntity;

public final class EntityUtil {
	private EntityUtil() {
	}

	public static AuthorityEntity parseEntity(File file) {
		AuthorityEntity entity = new AuthorityEntity();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(new FileInputStream(file))))) {
			// 公司信息
			br.readLine();
			// 产品注册码
			entity.setRegCode(br.readLine().split("：")[1]);
			// 硬件A序列号
			entity.setHddSer(br.readLine().split("：")[1]);
			// 硬件B序列号
			entity.setCpuSer(br.readLine().split("：")[1]);
			// 产品代号
			entity.setProductID(br.readLine().split("：")[1]);
			// 生产日期
			entity.setFromDate(br.readLine().split("：")[1]);
			// 结束日期
			entity.setEndDate(br.readLine().split("：")[1]);
			// 节点数
			entity.setNode(Integer.parseInt(br.readLine().split("：")[1]));
			// 数字签名
			entity.setSign(br.readLine().split("：")[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	public static void saveEntity(AuthorityEntity entity, File file) {
		// 4-1、保存证书
		try (PrintWriter out = new PrintWriter(new FileOutputStream(file));) {
			// 会自动关闭流
			// 证书基本内容
			out.println("公司：无锡凯数科技有限公司");
			out.println("产品注册码：" + entity.getRegCode());
			out.println("硬件A：" + entity.getHddSer());
			out.println("硬件B：" + entity.getCpuSer());
			out.println("产品代码：" + entity.getProductID());
			out.println("生产日期：" + entity.getFromDate());
			out.println("有效期至：" + entity.getEndDate());
			out.println("节点数：" + entity.getNode());
			// siga:
			out.println("SIGN-A：" + DigestUtils.sha256Hex(entity.toString()));
			// // 2、保存公司公钥
			// out.println("PUB-KEY：" + Base64.encodeBase64String(pubKey.getEncoded()));
		} catch (IOException e) {
			throw new RuntimeException("");
		}
	}
}
