package com.course.controller;

import com.course.dto.CourseDTO;
import com.course.entity.Instructors;
import com.course.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("instructor")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<CourseDTO>> courses(@PathVariable Integer id){
        return ResponseEntity.ok(service.getInstructorCourses(id));
    }
}
