package com.nantian.ecm.usdm.quartz.service.impl;

import static org.quartz.JobBuilder.newJob;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import org.quartz.CronExpression;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import com.nantian.ecm.usdm.quartz.service.SchedulerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *@author Tanjiao
 *@date 2015-11-23����01:35:07
 *@version 1.0
 */

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {
	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class); 
	
	
	private static final String NULLSTRING = null;
	private static final Date NULLDATE = null;
	

	private Scheduler scheduler;

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

	private JobDetail jobDetail;


	public void schedule(String cronExpression) {
		schedule(NULLSTRING, cronExpression);
	}

	public void schedule(String name, String cronExpression) {
		schedule(name, NULLSTRING, cronExpression);
	}

	public void schedule(String name, String group, String cronExpression) {
		try{
			schedule(name, group, new CronExpression(cronExpression));
		}catch(ParseException e){
			throw new IllegalArgumentException(e);
		}
	}

	public void schedule(CronExpression cronExpression) {
		schedule(NULLSTRING, cronExpression);	
	}

	public void schedule(String name, CronExpression cronExpression) {
		schedule(name, NULLSTRING, cronExpression);
	}

	public void schedule(String name, String group,CronExpression cronExpression) {
		
		name = "triggerName";
		group = "CronTriggerGroup";
				
		
		if(isValidExpression(cronExpression)){
			
			CronTriggerImpl trigger = new CronTriggerImpl();
			trigger.setCronExpression(cronExpression);
			trigger.setName(name);
			trigger.setGroup(group);
			
			TriggerKey triggerKey = new TriggerKey(name, group);
			logger.info("cron表达式："+trigger.getCronExpression() + ",triggerName: " +trigger.getName()+", triggerGroup: "+trigger.getGroup()+"!");
			
			logger.info("��ȡ��triggerKey:" + triggerKey);
			
			System.out.println("jobDetail"+jobDetail.getKey().getName());
			
			trigger.setJobName(jobDetail.getKey().getName());
			
			System.out.println("triggerKey" + trigger);
			logger.info("JobName:" + jobDetail.getKey().getName());
			logger.info("JobGroup:" + jobDetail.getKey().getGroup());
			
			trigger.setKey(triggerKey);
			
			try{
				scheduler.addJob(jobDetail, true);
				logger.info("ִ��addJob");
				if(scheduler.checkExists(triggerKey)){
					//暂停，重新修改任务
					scheduler.rescheduleJob(triggerKey, trigger);
					logger.info("ִ��rescheduleJob");
				}else{ 
					//执行任务
					scheduler.scheduleJob(trigger);
					logger.info("ִ��������" + trigger);
				}
			}catch(SchedulerException e){
				throw new IllegalArgumentException(e);
			}
		}
	}

	public void schedule(Date startTime) {
		schedule(startTime, NULLDATE);
	}

	public void schedule(Date startTime, String group) {
		schedule(startTime, NULLDATE, group);
	}

	public void schedule(String name, Date startTime) {
		schedule(name, startTime, NULLDATE);	
	}

	public void schedule(String name, Date startTime, String group) {
		schedule(name, startTime, NULLDATE, group);
	}

	public void schedule(Date startTime, Date endTime) {
		schedule(startTime, endTime, 0);
	}

	public void schedule(Date startTime, Date endTime, String group) {
		schedule(startTime, endTime, 0, group);
	}

	public void schedule(String name, Date startTime, Date endTime) {
		schedule(name, startTime, endTime, 0);
	}

	public void schedule(String name, Date startTime, Date endTime, String group) {
		schedule(name, startTime, endTime, 0, group);
	}

	public void schedule(Date startTime, int repeatCount) {
		schedule(null, startTime, NULLDATE, 0);	
	}

	public void schedule(Date startTime, Date endTime, int repeatCount) {
		schedule(null, startTime, endTime, 0);	
	}

	public void schedule(Date startTime, Date endTime, int repeatCount,
			String group) {
		schedule(null, startTime, endTime, 0, group);
	}
	
	public void schedule(String name, Date startTime, Date endTime,
			int repeatCount) {
		schedule(name, startTime, endTime, 0, 0L);
	}

	public void schedule(String name, Date startTime, Date endTime,
			int repeatCount, String group) {
		schedule(name, startTime, endTime, 0, 0L, group);
	}

	public void schedule(Date startTime, int repeatCount, long repeatInterval) {
		schedule(null, startTime, NULLDATE, repeatCount, repeatInterval);	
	}

	public void schedule(Date startTime, Date endTime, int repeatCount,
			long repeatInterval) {
		schedule(null, startTime, endTime, repeatCount, repeatInterval);
	}

	public void schedule(Date startTime, Date endTime, int repeatCount,
			long repeatInterval, String group) {
		schedule(null, startTime, endTime, repeatCount, repeatInterval, group);
	}

	public void schedule(String name, Date startTime, Date endTime,
			int repeatCount, long repeatInterval) {
		schedule(name, startTime, endTime, repeatCount, repeatInterval, NULLSTRING);
	}

	public void schedule(String name, Date startTime, Date endTime,
			int repeatCount, long repeatInterval, String group) {
		name = "triggerName";
		group = "triggerGroup";
		if(this.isValidExpression(startTime)){
			if(name == null || name.trim().equals("")){
				name = UUID.randomUUID().toString();
			}
			TriggerKey triggerKey = new TriggerKey(name, group);
			SimpleTriggerImpl trigger = new SimpleTriggerImpl();
			trigger.setKey(triggerKey);
			trigger.setJobName(jobDetail.getKey().getName());
			
			trigger.setStartTime(startTime);
			trigger.setEndTime(endTime);
			trigger.setRepeatCount(repeatCount);
			trigger.setRepeatInterval(repeatInterval);
			
			try{
				scheduler.addJob(jobDetail, true);
				if(scheduler.checkExists(triggerKey)){
					scheduler.rescheduleJob(triggerKey, trigger);
				}else{
					scheduler.scheduleJob(trigger);
				}
			}catch(SchedulerException e){
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	public void pauseTrigger(String triggerName) {
		pauseTrigger(triggerName, NULLSTRING);
	}

	public void pauseTrigger(String triggerName, String group) {
		try{
			scheduler.pauseTrigger(new TriggerKey(triggerName, group));//ֹͣ������
		}catch(SchedulerException e){
			throw new RuntimeException(e); 
		}
	}

	public boolean removeTrigger(String triggerName) {
		
		return removeTrigger(triggerName, NULLSTRING);
	}

	public boolean removeTrigger(String triggerName, String group) {
		TriggerKey triggerKey = new TriggerKey(triggerName, group);
		try{
			scheduler.pauseTrigger(triggerKey);//ֹͣ������
			return scheduler.unscheduleJob(triggerKey);//�Ƴ���
		}catch(SchedulerException e){
			throw new RuntimeException(e);
		}
	}

	public void resumeTrigger(String triggerName) {
		schedule(triggerName, NULLSTRING);
	}

	//����������
	public void resumeTrigger(String triggerName, String group) {
		try{
			scheduler.resumeTrigger(new TriggerKey(triggerName, group));
		}catch(SchedulerException e){
			throw new RuntimeException(e);
		}
	}

	private boolean isValidExpression(final CronExpression cronExpression) {
		CronTriggerImpl trigger = new CronTriggerImpl();
		trigger.setCronExpression(cronExpression);
		Date date = trigger.computeFirstFireTime(null);
		return date != null && date.after(new Date());
	}
	
	private boolean isValidExpression(final Date startTime) {
		SimpleTriggerImpl trigger = new SimpleTriggerImpl();
		trigger.setStartTime(startTime);
		Date date = trigger.computeFirstFireTime(null);
		return date != null && date.after(new Date());
	}

}
