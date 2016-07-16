package com.nantian.ecm.usdm.quartz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.nantian.ecm.usdm.quartz.domain.ScheduleJob;
import com.nantian.ecm.usdm.quartz.service.TaskManagerService;


public class TaskManagerServiceImpl implements TaskManagerService {

	SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	
	/**
	 * 获取所有计划中的任务列表
	 * @throws SchedulerException 
	 */
	public List<ScheduleJob> getAllJob() throws SchedulerException {
	
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
		List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
		
		for(JobKey jobKey : jobKeys){
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			for(Trigger trigger : triggers){
				ScheduleJob job = new ScheduleJob();
				job.setJobName(jobKey.getName());
				job.setGroupName(jobKey.getGroup());
				job.setDescription("触发器:"+ trigger.getKey());
				
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				job.setJobState(triggerState.name());
				if(trigger instanceof CronTrigger){
					CronTrigger cronTrigger = (CronTrigger) trigger;
					String cronExpression = cronTrigger.getCronExpression();
					job.setCronExpression(cronExpression);
				}
				jobList.add(job);
			}
		}
		return jobList;
	}

	/**
	 * 所有正在运行的job
	 * @throws SchedulerException 
	 */
	public List<ScheduleJob> getRunningJob() throws SchedulerException {
		Scheduler scheduler = schedulerFactory.getScheduler();
		List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
		List<ScheduleJob> jobList = new ArrayList<ScheduleJob>(executingJobs.size());
		for(JobExecutionContext executingJob : executingJobs){
			ScheduleJob job = new ScheduleJob();
			JobDetail jobDetail = executingJob.getJobDetail();
			JobKey jobKey = jobDetail.getKey();
			Trigger trigger = executingJob.getTrigger();
			
			job.setJobName(jobKey.getName());
			job.setGroupName(jobKey.getGroup());
			job.setDescription("触发器:" + trigger.getKey());
			Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			job.setJobState(triggerState.name());
			if(trigger instanceof CronTrigger){
				CronTrigger cronTrigger = (CronTrigger) trigger;
				String cronExpression = cronTrigger.getCronExpression();
				job.setCronExpression(cronExpression);
			}
			jobList.add(job);
		}
		return jobList;
	}

	/**
	 * 暂停一个job
	 * @throws SchedulerException 
	 */
	public void pauseJob(ScheduleJob scheduleJob) throws SchedulerException {
		
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getGroupName());
		scheduler.pauseJob(jobKey);

	}

	/**
	 * 重启一个job
	 * @throws SchedulerException 
	 */
	public void resumeJob(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getGroupName());
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 删除一个job
	 * @throws SchedulerException 
	 */
	public void deleteJob(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getGroupName());
		scheduler.deleteJob(jobKey);
	}

	/**
	 * 立即执行一个job
	 * @throws SchedulerException 
	 */
	public void runJobNow(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getGroupName());
		scheduler.triggerJob(jobKey);
	}

	/**
	 * 更新JOB的时间表达式
	 * @throws SchedulerException 
	 */
	public void updateCronExpression(ScheduleJob scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactory.getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getGroupName());
		
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		//判断cron表达式是否正确
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		
		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

		scheduler.rescheduleJob(triggerKey, trigger);
		
	}

}
