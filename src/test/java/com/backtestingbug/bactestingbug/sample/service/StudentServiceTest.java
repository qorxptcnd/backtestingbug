package com.backtestingbug.bactestingbug.sample.service;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.backtestingbug.sample.dto.AddStudentReqDto;
import com.backtestingbug.sample.dto.RetrieveStudentsReqDto;
import com.backtestingbug.sample.dto.RetrieveStudentsResDto;
import com.backtestingbug.sample.dto.UpdateStudentReqDto;
import com.backtestingbug.sample.entity.Student;
import com.backtestingbug.sample.enums.MajorCd;
import com.backtestingbug.sample.repository.StudentRepository;
import com.backtestingbug.sample.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 학생 서비스 테스트
 */
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;


    /**
     * addStudentTest
     * @Author gkgjs
     * @Description : DB에 학생을 추가한다.
     **/
    @Test
    public void addStudentTest() {

        AddStudentReqDto reqDto = new AddStudentReqDto();

        given(this.studentRepository.save(any())).willReturn(new Student());

        Student student = this.studentService.addStudent(reqDto);

        assertNotNull(student);

    }

    /**
     * updateStudentTest
     * @Author gkgjs
     * @Description : 학생 정보를 업데이트한다.
     **/
    @Test
    public void updateStudentTest() throws Exception {

        UpdateStudentReqDto reqDto = new UpdateStudentReqDto();
        reqDto.setName("B");

        Student existStudent = Student.builder()
                .id(1L)
                .name("A")
                .age(20L)
                .majorCd(MajorCd.CS)
                .build();

        given(this.studentRepository.findById(any())).willReturn(Optional.of(existStudent));
        given(this.studentRepository.save(any())).willReturn(existStudent);

        Student updatedStudent = this.studentService.updateStudent(any(), reqDto);

        assertEquals(updatedStudent.getName(), "B");
    }

    /**
     * updateStudentExceptionTest
     * @Author gkgjs
     * @Description : 존재하지 않는 학생을 업데이트한다.
     **/
    @Test
    public void updateStudentExceptionTest() throws Exception {

        given(this.studentRepository.findById(any())).willReturn(Optional.empty());

        assertThrows(Exception.class, () -> this.studentService.updateStudent(any(), new UpdateStudentReqDto()));

    }

    /**
     * retrieveStudentTest
     * @Author 하헌규
     * @Description : Id로 학생을 조회한다.
     **/
    @Test
    public void retrieveStudentTest() throws Exception {

        Student existStudent = Student.builder()
                .id(1L)
                .name("A")
                .age(20L)
                .majorCd(MajorCd.CS)
                .build();

        given(this.studentRepository.findById(any())).willReturn(Optional.of(existStudent));

        assertNotNull(this.studentService.retrieveStudent(any()));

    }

    /**
     * retrieveStudentExceptionTest
     * @Author 하헌규
     * @Description : 존재하지 않는 Id로 학생을 조회한다.
     **/
    @Test
    public void retrieveStudentExceptionTest() {

        given(this.studentRepository.findById(any())).willReturn(Optional.empty());

        assertThrows(Exception.class, () -> this.studentService.retrieveStudent(any()));

    }

    /**
     * retrieveStudentsTest
     * @Author 하헌규
     * @Description : 전공코드로 학생 목록을 조회한다.
     **/
    @Test
    public void retrieveStudentsTest() {

        RetrieveStudentsReqDto reqDto = new RetrieveStudentsReqDto();
        reqDto.setPage(0);
        reqDto.setPerPageCnt(10);
        reqDto.setMajorCd(MajorCd.CS);

        Page studentPage = Mockito.mock(Page.class);

        given(this.studentRepository
                .findAll(any(Specification.class),any(PageRequest.class))).willReturn(studentPage);

        RetrieveStudentsResDto resDto = this.studentService.retrieveStudents(reqDto);

        assertNotNull(resDto);

    }

    /**
     * deleteStudentTest
     * @Author 하헌규
     * @Description : DB에서 학생을 삭제한다.
     **/
    @Test
    public void deleteStudentTest() {

        this.studentService.deleteStudent(1L);
        Mockito.verify(this.studentRepository, times(1)).deleteById(any());

    }

}
