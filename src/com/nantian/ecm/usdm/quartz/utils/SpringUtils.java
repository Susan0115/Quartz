package com.nantian.ecm.usdm.quartz.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 获取Spring Bean的封装类
 * @author tanjiao
 *
 */
public class SpringUtils {

	private static ApplicationContext applicationContext;
	static{
		try{
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
	}
	
	public static Object getBean(String beanName){
		
		return applicationContext.getBean(beanName);
	}
}
