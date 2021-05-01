package com.backtestingbug;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : Main
 */
@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class BacktestingbugApplication {
    public static void main(String[] args) {
        SpringApplication.run(BacktestingbugApplication.class, args);
    }
}
