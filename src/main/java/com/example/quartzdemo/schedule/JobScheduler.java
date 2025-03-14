package com.example.quartzdemo.schedule;

import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {

    @Autowired
    MyJob myJob;

    // 使用spring框架的@Scheduled来调度
    @Scheduled(fixedDelayString = "5000")
    public void startMyJob() throws JobExecutionException {
        myJob.execute(null);
    }
}
