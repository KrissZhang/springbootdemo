package com.self.springbootdemo.config;

import com.self.springbootdemo.schedule.ScheduleTask;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz配置类
 * @author zp
 */
@Configuration
public class QuartzConfig {

    /**
     * 配置定时任务
     * @param scheduleTask 需要执行的任务
     * @return MethodInvokingJobDetailFactoryBean
     */
    @Bean(name = "scheduleTask1Job")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask scheduleTask) {
        //Job详情
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        //是否并发执行
        jobDetail.setConcurrent(false);

        //设置任务名称
        jobDetail.setName("scheduleTask1Job");

        //设置任务分组
        jobDetail.setGroup("scheduleTask1JobGroup");

        //需要执行的对象
        jobDetail.setTargetObject(scheduleTask);

        //执行任务中需要执行的方法
        jobDetail.setTargetMethod("scheduleTask1");

        return jobDetail;
    }

    /**
     * 配置定时任务触发器
     * @param jobDetail 定时任务
     * @return CronTriggerFactoryBean
     */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(JobDetail jobDetail){
        //任务触发器
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();

        //指示触发任务
        tigger.setJobDetail(jobDetail);

        //cron表达式，每10秒钟执行一次
        tigger.setCronExpression("0/10 * * * * ?");

        //设置触发器名字
        tigger.setName("jobDetailTrigger");

        return tigger;
    }

    /**
     * 配置调度工厂
     * @param jobTrigger 触发器
     * @return 调度工厂
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger jobTrigger) {
        //调度工厂
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

        //用于quartz集群，QuartzScheduler启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);

        //延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);

        //注册触发器
        factoryBean.setTriggers(jobTrigger);

        return factoryBean;
    }

}
