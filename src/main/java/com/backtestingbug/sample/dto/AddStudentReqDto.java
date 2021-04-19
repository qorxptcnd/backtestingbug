package com.backtestingbug.sample.dto;

import com.backtestingbug.sample.enums.MajorCd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 학생 추가 요청 Dto
 */
@Data
public class AddStudentReqDto {

    @ApiModelProperty(value = "학생명", name = "name", dataType = "String", example = "홍길동")
    @NotNull
    private String name;

    @ApiModelProperty(value = "학생나이", name = "age", dataType = "Long", example = "20")
    @NotNull
    private Long age;

    @ApiModelProperty(value = "전공코드", name = "majorCd", dataType = "MajorCd", example = "CS")
    @NotNull
    private MajorCd majorCd;

}
