package com.course.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentCourseDTO {
    private String studentFullName;
    private String courseTitle;
    private Double price;
}
