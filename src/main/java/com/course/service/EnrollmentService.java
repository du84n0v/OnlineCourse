package com.course.service;

import com.course.mapper.CourseStudentCountMapper;
import com.course.mapper.StudentCourseInstructorMapper;
import com.course.mapper.StudentCoursesMapper;
import com.course.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    public List<StudentCoursesMapper> getStudentCourses(Integer studentId) {
        return repository.getStudentEnrollments(studentId);
    }

    public List<CourseStudentCountMapper> getCourseStudentCount(Integer courseId) {
        return repository.getCourseStudentCount(courseId);
    }

    public List<CourseStudentCountMapper> getTop5Courses() {
        return repository.getTop5Courses();
    }

    public List<StudentCourseInstructorMapper> getStudentCourseDetailed(Integer studentId) {
        return repository.getStudentCourseDetailed(studentId);
    }
}
