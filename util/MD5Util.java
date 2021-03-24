package com.ctr.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * MD5工具类
 * 
 * <p>FileName：MD5Util</p>
 * <p>Author：yifeihu</p>
 * <p>Date：2016年5月6日 上午11:29:50</p>
 * <p>Version 1.0</p>
 */
public class MD5Util {
	
	public final static Logger LOG = LoggerFactory.getLogger(MD5Util.class);

	public static void main(String[] args) {
//		String s1 = "0000123qwe!@#";
//		System.out.println(md5(s1));
//		
		String filePath ="f://关于tomcat漏洞解决方法2.pdf";
		String filePath1 ="f://关于tomcat漏洞解决方法21.pdf";
		System.out.println(getMD5(filePath));
		System.out.println("---------------------");
		System.out.println(getMD5(filePath1));
	}

	/**
	 * 
	 * md5加密
	 * 
	 * MD5Util.md5<BR>
	 * <p>Author：yifeihu</p>
	 * <p>Date：2016年5月6日 上午11:29:42</p>
	 * @param str
	 * @return
	 * @throws
	 */
	public static String md5(String str) {
		MessageDigest messageDigest = null;   
        try {   
            messageDigest = MessageDigest.getInstance("MD5");   
            messageDigest.reset();   
   
            messageDigest.update(str.getBytes("UTF-8"));   
        } catch (NoSuchAlgorithmException e) {   
            System.exit(-1);   
        } catch (UnsupportedEncodingException e) {   
            LOG.error(e.getMessage());   
        }   
   
        byte[] byteArray = messageDigest.digest();   
   
        System.out.println("md5方法，字节为："+byte2hex(byteArray));
        StringBuffer md5StrBuff = new StringBuffer();   
   
        for (int i = 0; i < byteArray.length; i++) {               
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)   
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));   
            else   
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));   
        }   
   
        return md5StrBuff.toString().toUpperCase();   
	}
	
	public static String getMD5(String path) {
        BigInteger bi = null;
        byte[] b =null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            File f = new File(path);
            FileInputStream fis = new FileInputStream(f);
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            fis.close();
            b = md.digest();
            System.out.println("getMD5Three方法，字节为："+byte2hex(b));
            bi = new BigInteger(1, b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer returnStr = new StringBuffer();
        
        for (int i = 0; i < b.length; i++) {               
            if (Integer.toHexString(0xFF & b[i]).length() == 1)   
            	returnStr.append("0").append(Integer.toHexString(0xFF & b[i]));   
            else   
            	returnStr.append(Integer.toHexString(0xFF & b[i]));   
        }   
        return returnStr.toString().toUpperCase();   
    }

	public void testDigest()
	  {
	   try {
	     String myinfo="0000123qwe!@#";
	    //java.security.MessageDigest alg=java.security.MessageDigest.getInstance("MD5");
	      java.security.MessageDigest alga=java.security.MessageDigest.getInstance("SHA-1");
	      alga.update(myinfo.getBytes());
	      byte[] digesta=alga.digest();
	      System.out.println("本信息摘要是:"+byte2hex(digesta));
	      //通过某中方式传给其他人你的信息(myinfo)和摘要(digesta) 对方可以判断是否更改或传输正常
	      
	      java.security.MessageDigest algb=java.security.MessageDigest.getInstance("SHA-1");
	      algb.update(myinfo.getBytes());
	      if (algb.isEqual(digesta,algb.digest())) {
	         System.out.println("信息检查正常");
	       }
	       else
	        {
	          System.out.println("摘要不相同");
	         }
	   }
	   catch (java.security.NoSuchAlgorithmException ex) {
	     System.out.println("非法摘要算法");
	   }
	  }
	  public static String byte2hex(byte[] b) //二行制转字符串
	    {
	     String hs="";
	     String stmp="";
	     for (int n=0;n<b.length;n++)
	      {
	       stmp=(java.lang.Integer.toHexString(b[n] & 0XFF));
	       if (stmp.length()==1) hs=hs+"0"+stmp;
	       else hs=hs+stmp;
	       if (n<b.length-1)  hs=hs+":";
	      }
	     return hs.toUpperCase();
	    }
	
}
