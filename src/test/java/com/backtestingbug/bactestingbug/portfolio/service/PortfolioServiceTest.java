package com.backtestingbug.bactestingbug.portfolio.service;

import com.backtestingbug.portfolio.repository.PortfolioRepository;
import com.backtestingbug.portfolio.service.PortfolioService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;


/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description :
 */
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class PortfolioServiceTest {

    @InjectMocks
    private PortfolioService portfolioService;

    @Mock
    private PortfolioRepository portfolioRepository;


}
