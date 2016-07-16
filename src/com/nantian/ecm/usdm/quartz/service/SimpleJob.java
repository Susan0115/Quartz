package com.nantian.ecm.usdm.quartz.service;

import java.io.Serializable;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 *@author Tanjiao
 *@date 2015-11-17����3:26:12
 *@version 1.0
 */
public class SimpleJob extends QuartzJobBean{
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("***************************************");
		System.out.println("executeInternal:-----------------123456789------------" + new Date().toString());
		System.out.println("***************************************");
		
	}

}
