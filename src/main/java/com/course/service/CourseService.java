package com.course.service;

import com.course.dto.CourseDTO;
import com.course.dto.CourseIncomeDTO;
import com.course.dto.CourseStudentCountDTO;
import com.course.entity.Course;
import com.course.mapper.CourseIncomeMapper;
import com.course.mapper.CourseStudentCountMapper;
import com.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;
    @Autowired
    private EnrollmentService enrollmentService;

    public CourseDTO save(CourseDTO dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setPrice(dto.getPrice());
        course.setDuration(dto.getDuration());

        repository.save(course);
        return dto;
    }

    public List<CourseStudentCountDTO> getCourseStudentCount(Integer courseId) {
        List<CourseStudentCountMapper> list = enrollmentService.getCourseStudentCount(courseId);

        List<CourseStudentCountDTO> result = new LinkedList<>();
        for (CourseStudentCountMapper ls : list) {
            result.add(new CourseStudentCountDTO(ls.getCourseTitle(), ls.getStudentCount()));
        }

        return result;
    }

    public List<CourseStudentCountDTO> getTop5Courses() {
        List<CourseStudentCountMapper> list = enrollmentService.getTop5Courses();

        List<CourseStudentCountDTO> result = new LinkedList<>();
        for (CourseStudentCountMapper ls : list) {
            result.add(new CourseStudentCountDTO(ls.getCourseTitle(), ls.getStudentCount()));
        }

        return result;
    }

    public List<CourseIncomeDTO> getEachCourseIncome() {
        List<CourseIncomeMapper> list = enrollmentService.getEachCourseIncome();

        List<CourseIncomeDTO> result = new LinkedList<>();
        for (CourseIncomeMapper ls : list) {
            result.add(new CourseIncomeDTO(ls.getTitle(), ls.getIncome()));
        }
        return result;
    }

}
