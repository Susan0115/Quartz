package com.nantian.ecm.usdm.quartz.service;

import java.util.List;

import com.nantian.ecm.usdm.quartz.domain.ScheduleJob;

/**
 *@author Tanjiao
 *@date 2015-11-23����02:32:25
 *@version 1.0
 */
public interface JobService {
	
	/**
	 * ����Job
	 */
	void startJob();

	/**
	 * ��ȡ���мƻ��е������б�
	 * @return
	 */
	List<ScheduleJob> getAllJob();
	
	/**
	 * �����������е�Job
	 * @return
	 */
	List<ScheduleJob> getRunningJob();
	
	/**
	 * ��ͣһ��job
	 * @param scheduleJob
	 */
	void pauseJob(ScheduleJob scheduleJob);
	
	/**
	 * �ָ�һ��Job
	 * @param scheduleJob
	 */
	void resumeJob(ScheduleJob scheduleJob);
	
	/**
	 * ɾ��һ��Job
	 * @param scheduleJob
	 */
	void deleteJob(ScheduleJob scheduleJob);
	
	/**
	 * b��ִ��һ��Job
	 * @param scheduleJob
	 */
	void runJobNow(ScheduleJob scheduleJob);
	
	/**
	 * ����JOBʱ����ʽ
	 * @param scheduleJob
	 */
	void updateJobCron(ScheduleJob scheduleJob);
	
	
	
	
}
