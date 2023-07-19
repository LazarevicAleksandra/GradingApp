package com.example.gradingapp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.gradingapp.model.Course;

public interface CourseServiceInterface {
    List<Course> getCourses();

    Course getCourse(Long id);

    Course getCourseByCode(String code);

    Course getCourseByName(String name);

    Course createCourse(Course course);

    Course updateCourse(Course course, Long id);

    @Transactional
    void deleteCourse(Long id);

    List<Course> getByTeacherId(Long id);

}
