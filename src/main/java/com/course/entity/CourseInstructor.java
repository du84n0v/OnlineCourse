package com.course.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "course_instructor")
public class CourseInstructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_id")
    private Integer courseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @Column(name = "instructor_id")
    private Integer instructorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", insertable = false, updatable = false)
    private Instructors instructor;
}
