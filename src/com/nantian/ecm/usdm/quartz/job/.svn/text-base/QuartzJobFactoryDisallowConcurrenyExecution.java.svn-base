package com.nantian.ecm.usdm.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nantian.ecm.usdm.quartz.domain.ScheduleJob;
import com.nantian.ecm.usdm.quartz.service.impl.SchedulerServiceImpl;
import com.nantian.ecm.usdm.quartz.utils.TaskUtils;

/**
 * 若一个方法一次未执行完成，则等待该方法执行完后才执行下次操作
 * @author tanjiao
 *
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrenyExecution implements Job {

	private static final Logger logger = LoggerFactory.getLogger(QuartzJobFactoryDisallowConcurrenyExecution.class); 
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
	
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");

		TaskUtils.invokMethod(scheduleJob);
	}

}
