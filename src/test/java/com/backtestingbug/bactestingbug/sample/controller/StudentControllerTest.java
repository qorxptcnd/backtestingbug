package com.backtestingbug.bactestingbug.sample.controller;

import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.backtestingbug.sample.controller.StudentController;
import com.backtestingbug.sample.dto.RetrieveStudentResDto;
import com.backtestingbug.sample.dto.RetrieveStudentsResDto;
import com.backtestingbug.sample.entity.Student;
import com.backtestingbug.sample.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;


/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-19
 * @description : 학생 컨트롤러 테스트
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
@ActiveProfiles("test")
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * addStudentTest
     * @Author 하헌규
     * @Description : 학생을 추가한다.
     **/
    @Test
    public void addStudentTest() throws Exception {

        Student student = Mockito.mock(Student.class);

        Map<String,String> params = new HashMap<>();
        params.put("name","name");
        params.put("age","10");
        params.put("majorCd","CS");

        String content = objectMapper.writeValueAsString(params);

        given(this.studentService.addStudent(any())).willReturn(student);

        mockMvc.perform(post("/v1/sample/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    /**
     * updateStudentTest
     * @Author 하헌규
     * @Description : 학생 정보를 업데이트한다.
     **/
    @Test
    public void updateStudentTest() throws Exception {
        Student student = Mockito.mock(Student.class);

        Map<String,String> params = new HashMap<>();
        params.put("name","name");
        params.put("age","10");
        params.put("majorCd","CS");

        String content = objectMapper.writeValueAsString(params);

        given(this.studentService.updateStudent(any(),any())).willReturn(student);

        mockMvc.perform(put("/v1/sample/student")
                .param("id","1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andDo(print());
    }

    /**
     * retrieveStudentTest
     * @Author 하헌규
     * @Description : 학생을 조회한다.
     **/
    @Test
    public void retrieveStudentTest() throws Exception {

        RetrieveStudentResDto resDto = new RetrieveStudentResDto(Mockito.mock(Student.class));

        given(this.studentService.retrieveStudent(any())).willReturn(resDto);

        mockMvc.perform(get("/v1/sample/student")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","1"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    /**
     * retrieveStudentsTest
     * @Author 하헌규
     * @Description : 학생목록을 조회한다.
     **/
    @Test
    public void retrieveStudentsTest() throws Exception {

        RetrieveStudentsResDto resDto = new RetrieveStudentsResDto(Mockito.mock(Page.class));

        given(this.studentService.retrieveStudents(any())).willReturn(resDto);

        mockMvc.perform(get("/v1/sample/student")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","1")
                .param("page","0")
                .param("perPageCnt","10")
                .param("majorCd","CS"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    /**
     * deleteStudentTest
     * @Author 하헌규
     * @Description : 학생 정보를 삭제한다.
     **/
    @Test
    public void deleteStudentTest() throws Exception {

        mockMvc.perform(delete("/v1/sample/student")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","1"))
                .andExpect(status().isOk())
                .andDo(print());

        Mockito.verify(this.studentService, times(1)).deleteStudent(any());
    }


}
