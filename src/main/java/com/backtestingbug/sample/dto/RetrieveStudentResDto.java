package com.backtestingbug.sample.dto;

import com.backtestingbug.sample.entity.Student;
import com.backtestingbug.sample.enums.MajorCd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 학생 조회 결과 Dto
 */
@Data
public class RetrieveStudentResDto {

    @ApiModelProperty(value = "학생ID", name = "id", dataType = "Long", example = "1")
    private Long id;

    @ApiModelProperty(value = "학생명", name = "name", dataType = "String", example = "홍길동")
    private String name;

    @ApiModelProperty(value = "학생나이", name = "age", dataType = "Long", example = "20")
    private Long age;

    @ApiModelProperty(value = "전공코드", name = "majorCd", dataType = "MajorCd", example = "CS")
    private MajorCd majorCd;

    public RetrieveStudentResDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
        this.majorCd = student.getMajorCd();
    }

}
