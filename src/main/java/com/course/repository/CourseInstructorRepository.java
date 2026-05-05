package com.course.repository;

import com.course.entity.CourseInstructor;
import com.course.mapper.InstructorCoursesMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseInstructorRepository extends CrudRepository<CourseInstructor, Integer> {

    @Query("SELECT ci.course.title as title, " +
            "ci.course.price AS price, " +
            "ci.course.duration AS duration " +
            "FROM CourseInstructor ci WHERE ci.instructorId =?1")
    List<InstructorCoursesMapper> getInstructorCourses(Integer instructorId);
}
