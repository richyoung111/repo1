package com.ctr.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 日期工具类
 *
 * <p>FileName：DateUtil</p>
 * <p>Author：yifeihu</p>
 * <p>Date：2016年5月5日 下午3:48:05</p>
 * <p>Version 1.0</p>
 */
public class DateUtil {
	public final static Logger LOG = LoggerFactory.getLogger(DateUtil.class);

	public static final String SHORT_DATE_PATTERN = "yyyyMMdd";

	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	public static final String DATE_PATTERN_CN = "yyyy年MM月dd日";

	public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATETIME = "yyyy-MM-dd hh:mm";
	
	public static final String YEAR = "yyyy";
	
	public static final String MONTH = "MM";
	
	public static final String YEAR_MONTH = "yyyy-MM";
	
	public static final String YEARMONTH = "yyyyMM";
	

	/**
	 * 日期解析格式：yyyyMMdd
	 */
	public static Date dateSParse(String str) {
		SimpleDateFormat format = new SimpleDateFormat(SHORT_DATE_PATTERN);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			LOG.error("异常：", e);
		}
		return date;
	}

	/**
	 * 日期解析格式：yyyy-MM-dd
	 */
	public static Date dateParse(String str) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			LOG.error("异常：", e);
		}
		return date;
	}
	
	/**
	 * 日期解析格式：yyyy-MM-dd HH:mm:ss
	 */
	public static Date dateTimeParse(String str) {
		SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERN);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			LOG.error("异常：", e);
		}
		return date;
	}

	/**
	 * 日期格式化：yyyy-MM-dd HH:mm:ss
	 */
	public static String dateLFormat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERN);
		String str = format.format(date);
		return str;
	}

	/**
	 * 日期格式化：yyyy-MM-dd
	 */
	public static String dateFormat(Date date,String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String str = format.format(date);
		return str;
	}

	/**
	 * 日期格式化：yyyyMMdd
	 */
	public static String dateSFormat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(SHORT_DATE_PATTERN);
		String str = format.format(date);
		return str;
	}
	
	
	/**
	 * 比较两个日期大小
	 */
	public static int compare_date(String DATE1, String DATE2) {
		SimpleDateFormat df = new SimpleDateFormat(SHORT_DATE_PATTERN);
	        try {
	            Date dt1 = df.parse(DATE1);
	            Date dt2 = df.parse(DATE2);
	            if (dt1.getTime() > dt2.getTime()) {
	                System.out.println("dt1 在dt2前");
	                return 1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	                System.out.println("dt1在dt2后");
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	}
	
	
	/**
	 * 比较两个日期大小
	 */
	public static int compare_date2(Date dt1, Date dt2) {
	        try {
	            if (dt1.getTime() > dt2.getTime()) {
	                System.out.println("dt1 在dt2前");
	                return 1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	                System.out.println("dt1在dt2后");
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	}
	
	/**
	 * 日期解析格式：yyyy-MM-dd
	 */
	public static Date dateParse2(String str) {
		SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERN);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			LOG.error("异常：", e);
		}
		return date;
	}
	
	/**
	 * 日期格式化：yyyy-MM-dd hh:mm
	 */
	public static String dateStringFormat(Date date,String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		String str = format.format(date);
		return str;
	}
	
    /**
     * 
     * 获取两个时间段内的分钟数
     * 
     * DateUtil.diffInMinutes<BR>
     * <p>Author：lvjie</p>
     * <p>Date：2016年10月8日 下午4:38:19</p>
     * @param date1
     * @param date2
     * @return
     * @throws
     */
    public static long diffInMinutes(Date date1, Date date2) {
        long d1 = date1 == null ? 0 : date1.getTime();
        long d2 = date2 == null ? 0 : date2.getTime();
        return (long) Math.ceil((d1 - d2) / (double) 60000);
    }
    

	/**
	 * 
	 * 取系统默认时区的当前时间
	 * 
	 * DateUtil.getDate<BR>
	 * <p>Author：lvjie</p>
	 * <p>Date：2016年10月12日 上午9:35:25</p>
	 * @return
	 * @throws
	 */
	public static Date getDate() {
		// Etc/GMT 是格林威治标准时间,得到的时间和默认时区是一样的
		// Etc/GMT+8 比林威治标准时间慢8小时,
		// Etc/GMT-8 东八区,我们比那快8小时所以减8
		// PRC 设置中国时区
		// Calendar.getInstance(TimeZone.getTimeZone("GMT-8:00")).getTime();
		Calendar cal = Calendar.getInstance(java.util.Locale.CHINA);
		return cal.getTime();
	}
	
	
	/**
	 * 日期格式化：yyyy-MM-dd HH:mm:ss
	 */
	public static long dateLFormatShiJianChuo(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERN);
		String str = format.format(date);
		Date d = new Date();
		try {
			d = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d.getTime();
	}
	
	/**
	 * 日期解析格式：yyyy-MM-dd
	 */
	public static Date dateParse3(String str) {
		SimpleDateFormat format = new SimpleDateFormat(DATETIME);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			LOG.error("异常：", e);
		}
		return date;
	}
	
	public static String dateToString(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
		return "";
	}
	
	public static String dateToString(Date date) {
		return dateToString(date, "yyyy-MM-dd hh:mm:ss");
	}
	
}
