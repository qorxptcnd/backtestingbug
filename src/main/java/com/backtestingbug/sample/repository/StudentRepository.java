package com.backtestingbug.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backtestingbug.sample.entity.Student;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description :
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
