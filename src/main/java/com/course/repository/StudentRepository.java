package com.course.repository;

import com.course.entity.Student;
import com.course.mapper.StudentMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT s.fullName AS fullName, " +
            "s.email AS email, " +
            "s.phone AS phone FROM Student s " +
            "LEFT JOIN Enrollment e on s.id = e.studentId " +
            "WHERE e.id IS NULL ")
    List<StudentMapper> getStudentNoCourse();
}
