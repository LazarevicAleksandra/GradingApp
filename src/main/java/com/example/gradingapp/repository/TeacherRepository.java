package com.example.gradingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.gradingapp.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Teacher findByNameAndSurnameContainingIgnoreCase(String name, String surname);
}
