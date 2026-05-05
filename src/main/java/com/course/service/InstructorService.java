package com.course.service;

import com.course.dto.CourseDTO;
import com.course.entity.CourseInstructor;
import com.course.mapper.InstructorCoursesMapper;
import com.course.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository repository;
    @Autowired
    private CourseInstructorService courseInstructorService;

    public List<CourseDTO> getInstructorCourses(Integer instructorId) {
        List<InstructorCoursesMapper> list = courseInstructorService.getInstructorCourses(instructorId);

        List<CourseDTO> result = new LinkedList<>();
        for (InstructorCoursesMapper ls : list) {
            result.add(new CourseDTO(ls.getTitle(), ls.getPrice(), ls.getDuration()));
        }
        return result;
    }
}
