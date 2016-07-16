package com.nantian.ecm.usdm.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nantian.ecm.usdm.quartz.domain.ScheduleJob;
import com.nantian.ecm.usdm.quartz.utils.TaskUtils;

/**
 * 计划任务执行处 无状态(可以执行并发)
 * @author tanjiao
 *
 */
public class QuartzJobFactory implements Job {
	
	private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class); 
	

	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");

		TaskUtils.invokMethod(scheduleJob);

	}

}
