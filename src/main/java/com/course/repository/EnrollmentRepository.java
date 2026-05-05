package com.course.repository;

import com.course.entity.Enrollment;
import com.course.mapper.CourseIncomeMapper;
import com.course.mapper.CourseStudentCountMapper;
import com.course.mapper.StudentCourseInstructorMapper;
import com.course.mapper.StudentCoursesMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {

    @Query("SELECT e.student.fullName AS studentName," +
            "e.course.title AS courseTitle, " +
            "e.course.price AS coursePrice " +
            "FROM Enrollment e WHERE e.studentId =?1")
    List<StudentCoursesMapper> getStudentEnrollments(Integer studentId);

    @Query("SELECT e.course.title AS courseTitle, " +
            "COUNT(e) AS studentCount " +
            "FROM Enrollment e " +
            "WHERE e.courseId =?1 " +
            "GROUP BY e.course.title")
    List<CourseStudentCountMapper> getCourseStudentCount(Integer courseId);

    @Query("SELECT e.course.title as courseTitle, " +
            "COUNT(e) AS studentCount FROM Enrollment e " +
            "GROUP BY e.course.title " +
            "ORDER BY COUNT(e) DESC " +
            "LIMIT 5")
    List<CourseStudentCountMapper> getTop5Courses();

    @Query("SELECT e.student.fullName AS studentName," +
            "e.course.title AS courseTitle," +
            "ci.instructor.fullName AS insturtorName " +
            "FROM Enrollment e " +
            "JOIN CourseInstructor ci ON ci.courseId = e.courseId " +
            "WHERE e.studentId =?1")
    List<StudentCourseInstructorMapper> getStudentCourseDetailed(Integer studentId);

    @Query("SELECT e.course.title AS title," +
            "e.course.price * COUNT(e) AS income " +
            "FROM Enrollment e " +
            "GROUP BY e.course.title, e.course.price")
    List<CourseIncomeMapper> getEachCourseIncome();
}
