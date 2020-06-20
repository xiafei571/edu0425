package edu0425.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

public class MD5Util {

	public static String textToMD5U16(String plainText) {
		String result = null;
		if (StringUtils.isBlank(plainText)) {// 如果是空的，返回null
			return null;
		} else {
			result = textToMD5L32(plainText);
			result = result.toUpperCase().substring(8, 24);
		}

		return result;
	}

	public static String textToMD5L32(String plainText) {
		String result = null;
		if (StringUtils.isBlank(plainText)) {// 如果是空的，返回null
			return null;
		} else {
			try {
				// 首先进行MD5类的实例化和初始化
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 把待加密的字符串转换成字节编码的格式
				byte[] btInput = plainText.getBytes();
				// 对得到的字节数组进行处理
				md.update(btInput);
				// 进行哈希运算 返回结果
				byte[] btResult = md.digest();
				// 哈希计算后的数据进行拼接
				StringBuilder sb = new StringBuilder();
				for (byte b : btResult) {
					int bt = b & 0xff;
					if (bt < 16) {
						sb.append(0);
					}
					sb.append(Integer.toHexString(bt));
				}
				result = sb.toString();

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(textToMD5L32("admin"));
		System.out.println(textToMD5U16("admin"));
	}

}
