package com.backtestingbug.sample.dto;

import com.backtestingbug.sample.entity.Student;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 학생목록 조회 결과 Dto
 */
@Data
public class RetrieveStudentsResDto {

    private int totalPageCnt;

    private long totalRetrieveCnt;

    private List<RetrieveStudentResDto> studentResDtoList;

    public RetrieveStudentsResDto(Page<Student> studentPage) {

        this.studentResDtoList = new ArrayList<>();
        studentPage.getContent().forEach(student -> studentResDtoList.add(new RetrieveStudentResDto(student)));

        this.totalPageCnt = studentPage.getTotalPages();
        this.totalRetrieveCnt = studentPage.getTotalElements();

    }

}
