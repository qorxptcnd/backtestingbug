package com.backtestingbug.batch.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
import yahoofinance.histquotes2.HistoricalDividend;

import java.util.Calendar;
import java.util.List;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-24
 * @description : Yahoo Finance API Configuration
 */

@Slf4j
@Configuration
public class YahooApiJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job YahooApiJob() {
        return jobBuilderFactory.get("yahooApiJob")
                .start(yahooApiStep1(null, null))
                .build();
    }

    @Bean
    @JobScope
    public Step yahooApiStep1(@Value("#{jobParameters[symbolNm]}") String symbolNm
            , @Value("#{jobParameters[requestDt]}") String requestDt) {
        return stepBuilderFactory.get("yahooApiStep1")
                .tasklet((contribution, chunkContext) -> {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Integer.valueOf(requestDt.substring(0,4))
                            , Integer.valueOf(requestDt.substring(4,6))
                            , Integer.valueOf(requestDt.substring(6,8)));

                    Stock tmp = YahooFinance.get(symbolNm, calendar, Interval.DAILY);

                    List<HistoricalDividend> tmpList = tmp.getDividendHistory(calendar);

                    log.info(">>>>>> Step1");
                    log.info(">>>>>> name= {}",tmp.getName());
                    log.info(">>>>>> yield= {}",tmp.getDividend().getAnnualYield());
                    return RepeatStatus.FINISHED;
                })
                .build();
    }


}
