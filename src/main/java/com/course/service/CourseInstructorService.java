package com.course.service;

import com.course.dto.CourseInstructorDTO;
import com.course.entity.CourseInstructor;
import com.course.mapper.InstructorCoursesMapper;
import com.course.repository.CourseInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInstructorService {

    @Autowired
    private CourseInstructorRepository repository;

    public CourseInstructorDTO save(CourseInstructorDTO dto) {
        CourseInstructor ci = new CourseInstructor();
        ci.setCourseId(dto.getCourseId());
        ci.setInstructorId(dto.getInstructorId());
        repository.save(ci);
        return dto;
    }

    public List<InstructorCoursesMapper> getInstructorCourses(Integer instructorId) {
        return repository.getInstructorCourses(instructorId);
    }
}
