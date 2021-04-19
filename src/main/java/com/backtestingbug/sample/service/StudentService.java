package com.backtestingbug.sample.service;

import com.backtestingbug.sample.dto.*;
import com.backtestingbug.sample.entity.Student;
import com.backtestingbug.sample.repository.specificaton.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.backtestingbug.sample.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : 학생 서비스
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * addStudent
     * @Author gkgjs
     * @Description : DB에 학생을 추가한다.
     **/
    public Student addStudent(AddStudentReqDto reqDto) {
        Student student = Student.builder()
                .name(reqDto.getName())
                .age(reqDto.getAge())
                .majorCd(reqDto.getMajorCd())
                .build();
        return this.studentRepository.save(student);
    }

    /**
     * updateStudent
     * @Author gkgjs
     * @Description : 학생 정보를 업데이트한다.
     **/
    @Transactional
    public Student updateStudent(Long id, UpdateStudentReqDto reqDto) throws Exception {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student Id not exists"));

        student.setName(reqDto.getName());
        student.setAge(reqDto.getAge());
        student.setMajorCd(reqDto.getMajorCd());

        this.studentRepository.save(student);

        return student;
    }

    /**
     * retrieveStudent
     * @Author 하헌규
     * @Description : Id로 학생을 조회한다.
     **/
    public RetrieveStudentResDto retrieveStudent(Long id) throws Exception {
        return new RetrieveStudentResDto(this.studentRepository
                .findById(id).orElseThrow(() -> new Exception("Student Id not exists")));
    }

    /**
     * retrieveStudents
     * @Author 하헌규
     * @Description : 전공코드로 학생 목록을 조회한다.
     **/
    public RetrieveStudentsResDto retrieveStudents(RetrieveStudentsReqDto reqDto) {

        Specification<Student> specification = StudentSpecification.equalMajorCd(reqDto.getMajorCd());

        PageRequest pageRequest = PageRequest.of(reqDto.getPage()
                , reqDto.getPerPageCnt(), Sort.by("name").descending());

        Page<Student> studentPage = this.studentRepository.findAll(specification, pageRequest);

        return new RetrieveStudentsResDto(studentPage);
    }

    /**
     * deleteStudent
     * @Author 하헌규
     * @Description : DB에 있는 학생을 삭제한다.
     **/
    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

}
