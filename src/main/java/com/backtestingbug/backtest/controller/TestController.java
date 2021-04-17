package com.backtestingbug.backtest.controller;

import com.backtestingbug.backtest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description :
 */

@RequestMapping("/v1")
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public ResponseEntity addTest() {
        String id = this.testService.addTest();
        return new ResponseEntity(id, HttpStatus.OK);
    }

}
