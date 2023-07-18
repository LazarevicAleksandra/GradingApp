package com.example.gradingapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.gradingapp.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByNameContainingIgnoreCase(String name);

    Course findByCodeContainingIgnoreCase(String code);

    List<Course> findByTeacherId(Long teacherId);
}