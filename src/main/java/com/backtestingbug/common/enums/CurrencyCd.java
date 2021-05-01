package com.backtestingbug.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 거래통화코드
 */
@Getter
@AllArgsConstructor
public enum CurrencyCd {

    USD("USD","미국달러"),
    KRW("KRW","원화"),
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
