package com.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentCourseInstructorDTO {
    private String studentName;
    private String courseTitle;
    private String instructorName;
}
