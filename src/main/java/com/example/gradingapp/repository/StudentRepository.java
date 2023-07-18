package com.example.gradingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.gradingapp.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByNameAndSurnameContainingIgnoreCase(String name, String surname);

    Student findByIndexNumberContainingIgnoreCase(String index);
}
