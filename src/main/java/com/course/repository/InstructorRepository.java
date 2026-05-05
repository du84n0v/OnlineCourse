package com.course.repository;

import com.course.entity.Instructors;
import com.course.mapper.InstructorMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InstructorRepository extends CrudRepository<Instructors, Integer> {

    @Query("SELECT i.fullName AS fullName, " +
            "i.experience AS experience FROM Instructors i " +
            "ORDER BY i.experience DESC ")
    List<InstructorMapper> getTopByExperience();
}
