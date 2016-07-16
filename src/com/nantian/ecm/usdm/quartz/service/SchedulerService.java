package com.nantian.ecm.usdm.quartz.service;

import java.util.Date;

import org.quartz.CronExpression;

/**
 *@author Tanjiao
 *@date 2015-11-23下午01:26:55
 *@version 1.0
 */

//动态调度服务接口
public interface SchedulerService {

	/**
	 * 根据Quartz Cron Expression 调度任务
	 * @param cornExpression
	 */
	void schedule(String cronExpression);
	
	/**
	 * 根据Quartz Cron Expression 调度任务
	 * @param name
	 * @param cronExpression
	 */
	void schedule(String name, String cronExpression);
	
	/**
	 * 根据Quartz Cron Expression 调度任务
	 * @param name  Quartz CronTrigger名称
	 * @param group Quartz CronTrigger组名称
	 * @param cronExpression Quartz表达式
	 */
	void schedule(String name, String group, String cronExpression);
	
	/**
	 * 根据Quartz Cron Expression调度任务
	 * @param cronExpression CronExpression表达式
	 */
	void schedule(CronExpression cronExpression);
	
	/**
	 * 根据Quartz Cron Expression调度任务
	 * @param name Quartz CronTrigger名称
	 * @param cronExpression Quartz表达式
	 */
	void schedule(String name, CronExpression cronExpression);
	
	void schedule(String name, String group, CronExpression cronExpression);
	
	/** 
     * 在startTime时执行调试一次 
     *  
     * @param startTime 
     *            调度开始时间 
     */ 
	void schedule(Date startTime);
	
	void schedule(Date startTime, String group); 
	
	/** 
     * 在startTime时执行调试一次 
     *  
     * @param name 
     *            Quartz SimpleTrigger 名称 
     * @param startTime 
     *            调度开始时间 
     */  
	void schedule(String name, Date startTime);
	
	void schedule(String name, Date startTime, String group);
	
	/** 
     * 在startTime时执行调试，endTime结束执行调度 
     *  
     * @param startTime 
     *            调度开始时间 
     * @param endTime 
     *            调度结束时间 
     */ 
	void schedule(Date startTime, Date endTime);
	
	void schedule(Date startTime, Date endTime, String group); 
	
	/** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次 
     *  
     * @param startTime 
     *            调度开始时间 
     * @param repeatCount 
     *            重复执行次数 
     */ 
	void schedule(Date startTime, int repeatCount);
	
	/** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次 
     *  
     * @param startTime 
     *            调度开始时间 
     * @param endTime 
     *            调度结束时间 
     * @param repeatCount 
     *            重复执行次数 
     */
	void schedule(Date startTime, Date endTime, int repeatCount);
	
	 /** 
     * 在startTime时执行调试，endTime结束执行调度 
     *  
     * @param name 
     *            Quartz SimpleTrigger 名称 
     * @param startTime 
     *            调度开始时间 
     * @param endTime 
     *            调度结束时间 
     */  
	void schedule(String name, Date startTime, Date endTime);
	
	void schedule(String name, Date startTime, Date endTime, String group);
	
	 /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次 
     *  
     * @param name 
     *            Quartz SimpleTrigger 名称 
     * @param startTime 
     *            调度开始时间 
     * @param endTime 
     *            调度结束时间 
     * @param repeatCount 
     *            重复执行次数 
     */
	void schedule(String name, Date startTime, Date endTime, int repeatCount);
	
	void schedule(String name, Date startTime, Date endTime, int repeatCount, String group);  
	
	 /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次，每隔repeatInterval秒执行一次 
     *  
     * @param startTime 
     *            调度开始时间 
     *  
     * @param repeatCount 
     *            重复执行次数 
     * @param repeatInterval 
     *            执行时间隔间 
     */  
    void schedule(Date startTime, int repeatCount, long repeatInterval);
    
    /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次，每隔repeatInterval秒执行一次 
     *  
     * @param startTime 
     *            调度开始时间 
     * @param endTime 
     *            调度结束时间 
     * @param repeatCount 
     *            重复执行次数 
     * @param repeatInterval 
     *            执行时间隔间 
     */ 
	void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval);
	
	void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval, String group);
	 /** 
     * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次，每隔repeatInterval秒执行一次 
     *  
     * @param name 
     *            Quartz SimpleTrigger 名称 
     * @param startTime 
     *            调度开始时间 
     * @param endTime 
     *            调度结束时间 
     * @param repeatCount 
     *            重复执行次数 
     * @param repeatInterval 
     *            执行时间隔间 
     */ 
	void schedule(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval);
	
	void schedule(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval, String group);  
	
	void schedule(Date startTime, Date endTime, int repeatCount, String group);

	/** 
     * 暂停触发器 
     *  
     * @param triggerName 
     *            触发器名称 
     */  
    void pauseTrigger(String triggerName);  
  
    /** 
     * 暂停触发器 
     *  
     * @param triggerName 
     *            触发器名称 
     * @param group 
     *            触发器组 
     */  
    void pauseTrigger(String triggerName, String group);  
  
    /** 
     * 恢复触发器 
     *  
     * @param triggerName 
     *            触发器名称 
     */  
    void resumeTrigger(String triggerName);  
  
    /** 
     * 恢复触发器 
     *  
     * @param triggerName 
     *            触发器名称 
     * @param group 
     *            触发器组 
     */  
    void resumeTrigger(String triggerName, String group);  
  
    /** 
     * 删除触发器 
     *  
     * @param triggerName 
     *            触发器名称 
     * @return 
     */  
    boolean removeTrigger(String triggerName);  
  
    /** 
     * 删除触发器 
     *  
     * @param triggerName 
     *            触发器名称 
     * @param group 
     *            触发器组 
     * @return 
     */  
    boolean removeTrigger(String triggerName, String group);  
	
}
