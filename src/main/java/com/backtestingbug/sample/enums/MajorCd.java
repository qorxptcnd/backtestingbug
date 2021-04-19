package com.backtestingbug.sample.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : 전공코드
 */
@Getter
@AllArgsConstructor
public enum MajorCd {

    ALL("ZZ","ALL"),
    CS("10","컴퓨터공학"),
    LAW("20","법학"),
    ;

    private String code;
    private String name;

    @JsonCreator
    public static MajorCd from(String s) {
        MajorCd majorCd = MajorCd.valueOf(s);
        return MajorCd.valueOf(s);
    }

}
