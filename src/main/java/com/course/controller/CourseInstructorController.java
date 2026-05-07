package com.course.controller;

import com.course.dto.CourseInstructorDTO;
import com.course.service.CourseInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course-instructor")
public class CourseInstructorController {
    @Autowired
    private CourseInstructorService service;

    @GetMapping("/save")
    public ResponseEntity<CourseInstructorDTO> save(@RequestBody CourseInstructorDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }
}
