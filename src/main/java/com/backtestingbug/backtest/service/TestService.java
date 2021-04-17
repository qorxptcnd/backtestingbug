package com.backtestingbug.backtest.service;

import com.backtestingbug.backtest.entity.Test;
import com.backtestingbug.backtest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description :
 */
@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;


    public String addTest() {
        Test test = this.testRepository.save(new Test());
        return test.getId().toString();
    }
}
