package com.xieke.test.springboottask;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
// 所有的定时任务都放在一个线程池中，定时任务启动时使用不同的线程。
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //设定一个长度10的定时任务线程池（默认单线程）
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    }
}