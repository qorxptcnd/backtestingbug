package com.backtestingbug.portfolio.controller;

import com.backtestingbug.portfolio.service.PortfolioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 포트폴리오 컨트롤러
 */
@Api(tags = {"1. backtestingbug - 포트폴리오 관리"})
@RequestMapping("/v1/backtestingbug")
@RestController
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    /**
     * 포트폴리오 추가
     * @Author 하헌규
     * @Description : 포트폴리오를 추가한다.
     **/
    @ApiOperation(value = "포트폴리오 추가", notes = "포트폴리오를 DB에 등록한다.")
    @PostMapping("/portfolio")
    public ResponseEntity addStudent() {
        this.portfolioService.test();
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
