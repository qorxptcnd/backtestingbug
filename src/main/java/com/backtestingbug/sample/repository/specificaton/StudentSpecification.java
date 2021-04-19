package com.backtestingbug.sample.repository.specificaton;

import com.backtestingbug.sample.entity.Student;
import com.backtestingbug.sample.enums.MajorCd;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 학생 Specification
 */
@Component
public class StudentSpecification {

    public static Specification<Student> equalMajorCd(MajorCd majorCd) {
        return (((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("majorCd"), majorCd)));
    }

}
