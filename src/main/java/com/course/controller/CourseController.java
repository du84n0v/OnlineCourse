package com.course.controller;

import com.course.dto.CourseIncomeDTO;
import com.course.dto.CourseStudentCountDTO;
import com.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/student-count/{id}")
    public ResponseEntity<List<CourseStudentCountDTO>> studentCount(@PathVariable Integer id){
        return ResponseEntity.ok(service.getCourseStudentCount(id));
    }

    @GetMapping("/top-5")
    public ResponseEntity<List<CourseStudentCountDTO>> top5Courses(){
        return ResponseEntity.ok(service.getTop5Courses());
    }

    @GetMapping("/course-income")
    public ResponseEntity<List<CourseIncomeDTO>> income(){
        return ResponseEntity.ok(service.getEachCourseIncome());
    }


}
