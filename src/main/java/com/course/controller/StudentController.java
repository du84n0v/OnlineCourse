package com.course.controller;

import com.course.dto.StudentCourseDTO;
import com.course.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/student-courses/{studentId}")
    public ResponseEntity<List<StudentCourseDTO>> studentCourse(@PathVariable Integer studentId){
        return ResponseEntity.ok(service.getStudentCourses(studentId));
    }
}
