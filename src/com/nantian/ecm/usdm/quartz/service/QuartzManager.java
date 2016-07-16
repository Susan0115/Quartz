package com.nantian.ecm.usdm.quartz.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 定时器任务调度管理器
 *@author Tanjiao
 *@date 2015-11-18下午11:28:06
 *@version 1.0
 */
public class QuartzManager {
	
	private final static Logger logger = LoggerFactory.getLogger(QuartzManager.class);

	private final String jobGroupName;
	
	private final String triggerGroupName;
	
	private Scheduler scheduler;
	
	private final static SchedulerFactory schedularFactory = new StdSchedulerFactory();
	
	private final static Map<String, QuartzManager> instanceMap = new ConcurrentHashMap<String, QuartzManager>();
	

	private QuartzManager(String jobGroupName, String triggerGroupName) {
		
		this.jobGroupName = jobGroupName;
		this.triggerGroupName = triggerGroupName;

	}
	
	
	private Scheduler getScheduler() throws SchedulerException{
		if(scheduler == null){
			scheduler = schedularFactory.getScheduler();
		}
		return scheduler;
	}
	
	
	
}
