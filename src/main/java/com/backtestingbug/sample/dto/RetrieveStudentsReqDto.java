package com.backtestingbug.sample.dto;

import com.backtestingbug.sample.enums.MajorCd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 학생 조회 요청 Dto
 */
@Data
public class RetrieveStudentsReqDto extends PageReqDto {

    @ApiModelProperty(value = "전공코드", name = "majorCd", dataType = "MajorCd", example = "CS")
    @NotNull
    private MajorCd majorCd;

}
