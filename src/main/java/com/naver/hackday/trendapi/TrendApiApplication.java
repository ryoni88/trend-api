package com.naver.hackday.trendapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@EntityScan(basePackageClasses = { TrendApiApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
@EnableScheduling
public class TrendApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrendApiApplication.class, args);
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }

    /* 멀티쓰레드로 구성시
    @Bean
    public TaskScheduler taskScheduler() {

        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);

        return taskScheduler;
    }
    */

}
