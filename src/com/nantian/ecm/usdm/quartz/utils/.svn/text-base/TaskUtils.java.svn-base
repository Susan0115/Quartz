package com.nantian.ecm.usdm.quartz.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.nantian.ecm.usdm.quartz.domain.ScheduleJob;
import com.nantian.ecm.usdm.quartz.job.QuartzJobFactory;



/**
 * 真正执行计划任务 
 * 通过scheduleJob的beanClass或spring来获得需要执行的类，
 * 通过methodName来确定执行哪个方法
 * @author tanjiao
 *
 */
public class TaskUtils {

	private static final Logger logger = LoggerFactory.getLogger(TaskUtils.class); 
	
	public static void invokMethod(ScheduleJob scheduleJob){
		Object object = null;
		Class clazz = null;
		
		//springId不为空，先按springId来查找bean
		if(StringUtils.isNotBlank(scheduleJob.getSpringId())){
			object = SpringUtils.getBean(scheduleJob.getSpringId());
		}else if(StringUtils.isNotBlank(scheduleJob.getBeanClass())){
			try{
				clazz = Class.forName(scheduleJob.getBeanClass());
				object = clazz.newInstance();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(null == object){
			logger.error("任务名称=[" + scheduleJob.getJobName()+ "]未启动成功，请检查是否配置正确!");
			return;
		}
		clazz = object.getClass();
		Method method = null;
		try{
			method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
			
		}catch(NoSuchMethodException e){
			logger.error("任务名称=[" + scheduleJob.getJobName() + "] 未启动成功，方法名设置错误！");
		}catch(SecurityException e){
			e.printStackTrace();
		}
		
		if(method != null){
			try{
				method.invoke(object);
			}catch(IllegalAccessException e){
				e.printStackTrace();
			}catch(IllegalArgumentException e){
				e.printStackTrace();
			}catch(InvocationTargetException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
}
