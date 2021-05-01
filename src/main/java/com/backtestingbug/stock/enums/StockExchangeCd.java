package com.backtestingbug.stock.enums;

import com.backtestingbug.common.enums.CurrencyCd;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 주식시장코드
 */
@Getter
@AllArgsConstructor
public enum StockExchangeCd {

    KSE("KSE","코스피"),
    KOSDAQ("KOSDAQ","코스닥"),
    NASDAQGS("NasdaqGS","나스닥"),
    NYSE("NYSE","뉴욕증권거래소"),
    ZZZ("ZZZ","불명"),
    ;

    private String code;
    private String name;

    @JsonCreator
    public static CurrencyCd from(String s) {
        CurrencyCd currencyCd = CurrencyCd.valueOf(s);
        return CurrencyCd.valueOf(s);
    }

}
