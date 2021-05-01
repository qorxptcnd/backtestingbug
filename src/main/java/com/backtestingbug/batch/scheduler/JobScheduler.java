package com.backtestingbug.batch.scheduler;

import com.backtestingbug.batch.job.YahooApiJobConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-26
 * @description : 배치 스케쥴러
 */
@Slf4j
@Component
public class JobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private YahooApiJobConfiguration yahooApiJobConfiguration;

    @Scheduled(cron = "0 0 8 * * 0-6") // 월~토 8시
    //@Scheduled(cron = "0 * * * * 0-6") // 테스트용
    public void runYahooApiJob() {
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("symbolNm", new JobParameter("BRK-A"));
//        confMap.put("requestDt", new JobParameter("20000101"));


        confMap.put("requestDt"
                , new JobParameter(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))));
        JobParameters jobParameters = new JobParameters(confMap);

        try {
            jobLauncher.run(yahooApiJobConfiguration.YahooApiJob(), jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException
        | JobParametersInvalidException | JobRestartException e) {
            log.error(e.getMessage());
        }

    }

}
