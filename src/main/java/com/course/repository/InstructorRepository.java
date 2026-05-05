package com.course.repository;

import com.course.entity.Instructors;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructors, Integer> {
}
