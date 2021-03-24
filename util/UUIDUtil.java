package com.ctr.base.util;

import java.util.UUID;

/**
 * 
 * UUID工具类
 *
 * <p>FileName：UUIDUtil</p>
 * <p>Author：yfh</p>
 * <p>Date：2019年5月10日 下午6:07:17</p>
 * <p>Version 1.0.0</p>
 */
public class UUIDUtil {

	public static String getUUID() {
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		return id;
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
	
}
