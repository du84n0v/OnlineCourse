package com.course.controller;

import com.course.dto.CourseDTO;
import com.course.dto.CourseIncomeDTO;
import com.course.dto.CourseStudentCountDTO;
import com.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping("/create")
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

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
