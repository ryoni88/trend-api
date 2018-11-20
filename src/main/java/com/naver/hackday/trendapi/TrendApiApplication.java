package com.naver.hackday.trendapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = { TrendApiApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
public class TrendApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrendApiApplication.class, args);
    }
}
