package com.xieke.test.springboottask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private int fixedDelayCount = 1;
    private int fixedRateCount = 1;
    private int initialDelayCount = 1;
    private int cronCount = 1;

    // fixedDelay：表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms；
    @Scheduled(fixedDelay = 5000)
    public void testFixDelay() {
        logger.info("===fixedDelay: 第{}次执行方法", fixedDelayCount++);
    }

    // fixedRate：表示按一定的频率执行任务，参数类型为long，单位ms；
    @Scheduled(fixedRate = 5000)
    public void testFixedRate() {
        logger.info("===fixedRate: 第{}次执行方法", fixedRateCount++);
    }

    // initialDelay：表示延迟多久再第一次执行任务，参数类型为long，单位ms；
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void testInitialDelay() {
        logger.info("===initialDelay: 第{}次执行方法", initialDelayCount++);
    }

    // cron表达式，指定任务在特定时间执行；
    @Scheduled(cron = "*/10 * * * * *") // 表示每10秒执行一次
    public void testCron() {
        logger.info("===cron: 第{}次执行方法", cronCount++);
    }

}