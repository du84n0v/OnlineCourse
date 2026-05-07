package com.course.service;

import com.course.dto.EnrollmentDTO;
import com.course.entity.Enrollment;
import com.course.mapper.CourseIncomeMapper;
import com.course.mapper.CourseStudentCountMapper;
import com.course.mapper.StudentCourseInstructorMapper;
import com.course.mapper.StudentCoursesMapper;
import com.course.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    public EnrollmentDTO save(EnrollmentDTO dto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(dto.getStudentId());
        enrollment.setCourseId(dto.getCourseId());
        enrollment.setEnrolledDate(LocalDate.now());
        repository.save(enrollment);
        return dto;
    }

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

    public List<CourseIncomeMapper> getEachCourseIncome() {
        return repository.getEachCourseIncome();
    }
}
