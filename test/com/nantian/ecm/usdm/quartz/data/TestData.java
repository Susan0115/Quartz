package com.nantian.ecm.usdm.quartz.data;

import java.util.Map;
import java.util.HashMap;

import com.nantian.ecm.usdm.quartz.domain.ScheduleJob;


/**
 *@author Tanjiao
 *@date 2015-11-23����03:15:32
 *@version 1.0
 */
public class TestData {
	//�ƻ�����map
	private static Map<String, ScheduleJob> jobMap = new HashMap<String, ScheduleJob>();

	static{
		for(int i = 0; i < 5; i++){
//			ScheduleJob job = new ScheduleJob();
//			job.setJobId("");
//			job.setJobName("" + i);
//			job.setJobGroup("");
//			job.setJobStatus("1");
//			job.setCronExpression("0/5 * * * * ?");
//			job.setDescription("��ݵ�������");
//			
		//	addJob(job);
			
		}
	}
	
	//�������
	public static void addJob(ScheduleJob scheduleJob){
	//	jobMap.put(scheduleJob.getJobGroup() + "_" + scheduleJob.getJobName(), scheduleJob);
	}
	
}
