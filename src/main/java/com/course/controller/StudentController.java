package com.course.controller;

import com.course.dto.StudentCourseDTO;
import com.course.dto.StudentCourseInstructorDTO;
import com.course.dto.StudentDTO;
import com.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/student-courses/{studentId}")
    public ResponseEntity<List<StudentCourseDTO>> studentCourse(@PathVariable Integer studentId){
        return ResponseEntity.ok(service.getStudentCourses(studentId));
    }

    @GetMapping("/course-detailed/{id}")
    public ResponseEntity<List<StudentCourseInstructorDTO>> courseDetailed(@PathVariable Integer id){
        return ResponseEntity.ok(service.getStudentCoursesDetail(id));
    }

    @GetMapping("no-course")
    public ResponseEntity<List<StudentDTO>> noCourse(){
        return ResponseEntity.ok(service.getStudentNoCourse());
    }

}
