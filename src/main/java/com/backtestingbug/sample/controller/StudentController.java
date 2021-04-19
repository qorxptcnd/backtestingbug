package com.backtestingbug.sample.controller;

import com.backtestingbug.sample.dto.*;
import com.backtestingbug.sample.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : gkgjs
 * @version : 1.0.0
 * @date : 2021-04-17
 * @description : 학생 컨트롤러
 */
@Api(tags = {"99. Sample - 학생 관리"})
@RequestMapping("/v1/sample")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 학생 추가
     * @Author 하헌규
     * @Description : 학생을 추가한다.
     **/
    @ApiOperation(value = "학생추가", notes = "학생을 DB에 등록한다.")
    @PostMapping("/student")
    public ResponseEntity addStudent(@Valid @RequestBody AddStudentReqDto reqDto
            , BindingResult bindingResult) throws BindException {
        if(bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        this.studentService.addStudent(reqDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 학생 수정
     * @Author 하헌규
     * @Description : 학생 정보를 업데이트한다.
     **/
    @ApiOperation(value = "학생수정", notes = "학생 정보를 수정한다.")
    @PutMapping("/student")
    public ResponseEntity updateStudent(@RequestParam(value = "id") Long id
            , @Valid @RequestBody UpdateStudentReqDto reqDto, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        this.studentService.updateStudent(id, reqDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 학생 조회
     * @Author 하헌규
     * @Description : 학생을 조회한다.
     **/
    @ApiOperation(value = "학생조회", notes = "학생정보를 조회한다.")
    @GetMapping("/student")
    public ResponseEntity<RetrieveStudentResDto> retrieveStudent(@RequestParam(value = "id") Long id) throws Exception {
        return new ResponseEntity(this.studentService.retrieveStudent(id),HttpStatus.OK);
    }

    /**
     * 학생목록 조회
     * @Author 하헌규
     * @Description : 학생목록을 조회한다.
     **/
    @ApiOperation(value = "학생목록 조회", notes = "학생목록을 조회한다.")
    @GetMapping("/students")
    public ResponseEntity<RetrieveStudentsResDto> retrieveStudents(@ModelAttribute RetrieveStudentsReqDto reqDto) {
        return new ResponseEntity(this.studentService.retrieveStudents(reqDto),HttpStatus.OK);
    }

    /**
     * 학생 삭제
     * @Author 하헌규
     * @Description : 학생 정보를 삭제한다.
     **/
    @ApiOperation(value = "학생삭제", notes = "DB에서 학생을 삭제한다.")
    @DeleteMapping("/student")
    public ResponseEntity deleteStudent(@RequestParam(value = "id") Long id) {
        this.studentService.deleteStudent(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
