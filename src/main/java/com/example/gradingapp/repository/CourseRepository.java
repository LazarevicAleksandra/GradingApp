package com.example.gradingapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.gradingapp.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByNameContainingIgnoreCase(String name);

    Optional<Course> findByCodeContainingIgnoreCase(String code);

    List<Course> findByTeacherId(Long teacherId);
}