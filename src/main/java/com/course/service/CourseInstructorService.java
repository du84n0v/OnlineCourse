package com.course.service;

import com.course.mapper.InstructorCoursesMapper;
import com.course.repository.CourseInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInstructorService {

    @Autowired
    private CourseInstructorRepository repository;

    public List<InstructorCoursesMapper> getInstructorCourses(Integer instructorId) {
        return repository.getInstructorCourses(instructorId);
    }
}
