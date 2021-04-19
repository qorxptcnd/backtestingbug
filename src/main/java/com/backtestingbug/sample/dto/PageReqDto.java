package com.backtestingbug.sample.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 페이징 Dto
 */
@Data
public class PageReqDto {

    @ApiModelProperty(value = "페이지번호", name = "page", dataType = "int", example = "1")
    @NotNull
    private int page;

    @ApiModelProperty(value = "페이지당갯수", name = "perPageCnt", dataType = "int", example = "10")
    @NotNull
    private int perPageCnt;

}
