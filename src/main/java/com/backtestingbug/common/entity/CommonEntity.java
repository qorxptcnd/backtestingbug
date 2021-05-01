package com.backtestingbug.common.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 공통 관리 칼럼
 */

@MappedSuperclass
public class CommonEntity {

    @Column(name = "LAST_UPDATE_SERVICE_NM", length = 200)
    private String lastUpdateServiceNm;

    @Column(name = "LAST_UPDATE_DTTM")
    private LocalDateTime lastUpdateDttm;

    @Column(name = "FIRST_INSERT_SERVICE_NM", length = 200, updatable = false)
    private String firstInsertServiceNm;

    @Column(name = "FIRST_INSERT_DTTM", updatable = false)
    private LocalDateTime firstInsertDttm;

    public void setInsertColumns(String serviceNm) {
        LocalDateTime now = LocalDateTime.now();
        this.firstInsertDttm = now;
        this.firstInsertServiceNm = serviceNm;
        this.lastUpdateDttm = now;
        this.lastUpdateServiceNm = serviceNm;
    }

    public void setUpdateColumns(String serviceNm) {
        this.lastUpdateDttm = LocalDateTime.now();
        this.lastUpdateServiceNm = serviceNm;
    }


}
