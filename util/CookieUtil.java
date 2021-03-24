package com.ctr.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * cookie工具类
 *
 * <p>FileName：CookieUtil</p>
 * <p>Author：yifeihu</p>
 * <p>Date：2016年5月6日 下午4:18:45</p>
 * <p>Version 1.0</p>
 */
public class CookieUtil {
	
	public final static Logger LOG = LoggerFactory.getLogger(CookieUtil.class);
	
	/**
	 * 
	 * 设置cookie
	 * 
	 * CookieUtil.setCookie<BR>
	 * <p>Author：yifeihu</p>
	 * <p>Date：2016年5月6日 下午4:20:57</p>
	 * @param response
	 * @param name 名称
	 * @param value 值
	 * @param age 过期时间
	 * @throws
	 */
	public static void setCookie(HttpServletResponse response, String name,Object value, Integer age) {
        try {
        	Cookie cookie = new Cookie(name,URLEncoder.encode(value.toString(), "UTF-8"));
            //cookie.setDomain(PubConstantUtil.getValue("rootDomain"));
            response.setHeader("P3P","CP=\"NON DSP COR CURa ADMa DEVa TAIa PSAa PSDa IVAa IVDa CONa HISa TELa OTPa OUR UNRa IND UNI COM NAV INT DEM CNT PRE LOC\"");
            cookie.setPath("/");
            if(age != 0){
            	cookie.setMaxAge(age);
            }
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
        	LOG.error("设置cookie异常",e);
        }
	}
	
	/**
	 * 
	 * 获取cookie
	 * 
	 * CookieUtil.getCookie<BR>
	 * <p>Author：yifeihu</p>
	 * <p>Date：2016年5月6日 下午4:22:54</p>
	 * @param request
	 * @param name 名称
	 * @return 
	 * @throws 
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		String value = null;
		try {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equalsIgnoreCase(name)) {
						value = new String(URLDecoder.decode(c.getValue(),"UTF-8"));
						break;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			LOG.error("获取cookie异常",e);
		}
		return value;
	}
	
	/**
	 * 
	 * 删除cookie
	 * 
	 * CookieUtil.delCookie<BR>
	 * <p>Author：yifeihu</p>
	 * <p>Date：2016年5月6日 下午4:25:47</p>
	 * @param response
	 * @param name 名称
	 * @throws
	 */
	public static void delCookie(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name, null);
		// cookie.setDomain(PubConstantUtil.getValue("rootDomain"));
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
}
