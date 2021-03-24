package com.ctr.base.util;

import org.apache.commons.lang.StringUtils;

public class StringUtil extends StringUtils{
	
	public static boolean isEnAndNum(String str) {
		String regEx = "[0-9a-zA-Z]*";
		return  str.matches(regEx);
	}

	public static String formateString(String str, String... params) {
		for (int i = 0; i < params.length; i++) {
			str = str.replace("{" + i + "}", params[i] == null ? "" : params[i]);
		}
		return str;
	}

}
