package com.backtestingbug.backtest.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description :
 */

@Data
@Entity(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private Long id;

}
