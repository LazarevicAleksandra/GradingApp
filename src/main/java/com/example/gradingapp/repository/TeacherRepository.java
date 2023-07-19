package com.example.gradingapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.gradingapp.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    List<Teacher> findByNameAndSurnameContainingIgnoreCase(String name, String surname);
}
