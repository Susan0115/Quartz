package com.nantian.ecm.usdm.quartz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *@author Tanjiao
 *@date 2015-11-24����10:03:53
 *@version 1.0
 */
public class DateUtils {

	public static Date parse(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			return format.parse(dateStr);
		}catch(ParseException e){
			throw new RuntimeException(e);
		}
		
	}
}
