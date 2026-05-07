package com.course.controller;

import com.course.dto.EnrollmentDTO;
import com.course.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @PostMapping("/create")
    public ResponseEntity<EnrollmentDTO> save(@RequestBody EnrollmentDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }
}
