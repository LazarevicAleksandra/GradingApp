package com.example.gradingapp.service;

import java.util.List;

import com.example.gradingapp.model.Course;

public interface CourseServiceInterface {
    List<Course> getCourses();

    Course getCourse(Long id);

    Course saveCourse(Course course);

    void deleteCourse(Long id);

}
