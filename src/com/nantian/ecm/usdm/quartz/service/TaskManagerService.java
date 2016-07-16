package com.nantian.ecm.usdm.quartz.service;

import java.util.List;

import org.quartz.SchedulerException;

import com.nantian.ecm.usdm.quartz.domain.ScheduleJob;
/**
 * 任务操作类
 * @author tanjiao
 *
 */
public interface TaskManagerService {


	/**
	 * 获取所有计划中的任务列表
	 * @return
	 * @throws SchedulerException 
	 */
	public List<ScheduleJob> getAllJob() throws SchedulerException;
	/**
	 * 所有正在运行的job
	 * @return
	 * @throws SchedulerException 
	 */
	public List<ScheduleJob> getRunningJob() throws SchedulerException;
	/**
	 * 暂停一个job
	 * @param scheduleJob
	 * @throws SchedulerException 
	 */
	public void pauseJob(ScheduleJob scheduleJob) throws SchedulerException;
	/**
	 * 恢复一个job
	 * @param scheduleJob
	 * @throws SchedulerException 
	 */
	public void resumeJob(ScheduleJob scheduleJob) throws SchedulerException;
	/**
	 * 删除一个job
	 * @param scheduleJob
	 * @throws SchedulerException 
	 */
	public void deleteJob(ScheduleJob scheduleJob) throws SchedulerException;

	/**
	 * 立即执行一个Job
	 * @throws SchedulerException 
	 */
	public void runJobNow(ScheduleJob scheduleJob) throws SchedulerException;
	/**
	 * 更新cron表达式
	 * @param scheduleJob
	 * @throws SchedulerException 
	 */
	public void updateCronExpression(ScheduleJob scheduleJob) throws SchedulerException;
	

}
