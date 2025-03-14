package com.example.quartzdemo.schedule;

import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.*;

import java.util.concurrent.TimeUnit;

public class TestJob {
    @Test
    public void executeJob() throws SchedulerException, InterruptedException {
        // 出处：https://zhuanlan.zhihu.com/p/522284183

        // 1.创建调度器 Scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        // 2.创建JobDetail实例，并与MyJob类绑定(Job执行内容)
        JobDetail job = JobBuilder.newJob(MyJob.class)
            .withIdentity("job1", "group1")
            .build();

        // 3.构建Trigger实例,每隔指定秒执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("trigger1", "group1")
            .startNow()
            .withSchedule(SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever())
            .build();

        // 4.执行，开启调度器
        scheduler.scheduleJob(job, trigger);
        System.out.println(System.currentTimeMillis());
        scheduler.start();

        //主线程睡眠1分钟，然后关闭调度器
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println(System.currentTimeMillis());
    }
}
