package com.backtestingbug.portfolio.service;

import com.backtestingbug.portfolio.entity.Portfolio;
import com.backtestingbug.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 포트폴리오 서비스
 */
@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;


    public void test() {

        Portfolio portfolio = Portfolio.builder()
                .prtflNm("테스트")
                .prtflSymbol("TEST").prtflCagr(new BigDecimal(10)).build();

        portfolio.setInsertColumns("testService");

        this.portfolioRepository.save(portfolio);

    }


}
