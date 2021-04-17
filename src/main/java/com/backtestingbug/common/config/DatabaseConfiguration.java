package com.backtestingbug.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : Database 설정
 */
@Configuration
@PropertySource("classpath:/application.yaml")
public class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
     return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println(dataSource.toString());
        return dataSource;
    }

}
