package com.course.service;

import com.course.dto.StudentCourseDTO;
import com.course.mapper.StudentCoursesMapper;
import com.course.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private EnrollmentService enrollmentService;

    public List<StudentCourseDTO> getStudentCourses(Integer studentId) {
        List<StudentCoursesMapper> enrollments = enrollmentService.getStudentCourses(studentId);

        List<StudentCourseDTO> response = new LinkedList<>();
        for (StudentCoursesMapper e : enrollments) {
            response.add(new StudentCourseDTO(e.getStudentName(), e.getCourseTitle(), e.getCoursePrice()));
        }

        return response;
    }
}
