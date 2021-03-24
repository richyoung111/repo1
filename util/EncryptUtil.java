package com.ctr.base.util;

/**
 * 
 * 加密工具类
 *
 * <p>FileName：EncryptUtil</p>
 * <p>Author：yfh</p>
 * <p>Date：2019年5月10日 下午6:15:02</p>
 * <p>Version 1.0.0</p>
 */
public class EncryptUtil {
	
	public static String encryptUserPwd(String saltValue,String password) {
		StringBuilder userPwd = new StringBuilder();
		userPwd.append(saltValue).append(password);
		String md5Pwd = MD5Util.md5(userPwd.toString());
		return md5Pwd;
	}

}
