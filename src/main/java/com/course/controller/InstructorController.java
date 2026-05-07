package com.course.controller;

import com.course.dto.CourseDTO;
import com.course.dto.InstructorDTO;
import com.course.entity.Instructors;
import com.course.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instructor")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @PostMapping("/create")
    public ResponseEntity<InstructorDTO> create(@RequestBody InstructorDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<CourseDTO>> courses(@PathVariable Integer id){
        return ResponseEntity.ok(service.getInstructorCourses(id));
    }

    @GetMapping("/top")
    public ResponseEntity<List<InstructorDTO>> topByExperience(){
        return ResponseEntity.ok(service.getTopByExperience());
    }
}
