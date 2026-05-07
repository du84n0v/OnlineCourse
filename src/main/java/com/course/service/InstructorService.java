package com.course.service;

import com.course.dto.CourseDTO;
import com.course.dto.InstructorDTO;
import com.course.entity.CourseInstructor;
import com.course.entity.Instructors;
import com.course.mapper.InstructorCoursesMapper;
import com.course.mapper.InstructorMapper;
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

    public List<InstructorDTO> getTopByExperience() {
        List<InstructorMapper> list = repository.getTopByExperience();

        List<InstructorDTO> result = new LinkedList<>();
        for (InstructorMapper ls : list) {
            result.add(new InstructorDTO(ls.fullName(), ls.experience()));
        }
        return result;
    }

    public InstructorDTO save(InstructorDTO dto) {
        Instructors instructor = new Instructors();
        instructor.setFullName(dto.getFullName());
        instructor.setExperience(dto.getExperience());

        repository.save(instructor);
        return dto;
    }
}
