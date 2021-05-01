package com.backtestingbug.portfolio.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-05-01
 * @description : 리밸런싱 주기 코드
 */
@Getter
@AllArgsConstructor
public enum RblncPeriodCd {

    MONTHLY("1","달"),
    QUARTERLY("3","분기"),
    SEMI_ANNUALLY("6","반기"),
    ANNUALLY("12","년"),
    BANDS("BANDS","밴드"),
    ZZZ("ZZZ","불명"),
    ;

    private String code;
    private String name;

    @JsonCreator
    public static RblncPeriodCd from(String s) {
        RblncPeriodCd rblncPeriodCd = RblncPeriodCd.valueOf(s);
        return RblncPeriodCd.valueOf(s);
    }


}
