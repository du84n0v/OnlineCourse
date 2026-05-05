package com.course.service;

import com.course.dto.StudentCourseDTO;
import com.course.dto.StudentCourseInstructorDTO;
import com.course.mapper.StudentCourseInstructorMapper;
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

    public List<StudentCourseInstructorDTO> getStudentCoursesDetail(Integer studentId) {
        List<StudentCourseInstructorMapper> list = enrollmentService.getStudentCourseDetailed(studentId);

        List<StudentCourseInstructorDTO> result = new LinkedList<>();
        for (StudentCourseInstructorMapper ls : list) {
            result.add(new StudentCourseInstructorDTO(ls.studentName(), ls.courseTitle(), ls.instructorName()));
        }
        return result;
    }
}
