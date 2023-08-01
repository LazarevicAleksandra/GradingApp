package com.example.gradingapp.service;

import java.util.List;

import com.example.gradingapp.model.Student;

public interface StudentServiceInterface {
    List<Student> getStudents();

    Student getStudent(Long id);

    Student createStudent(Student student);

    Student updateStudent(Student student, Long id);

    void deleteStudent(Long id);

    List<Student> getByNameAndSurname(String name, String surname);

    Student getByIndexNumber(String index);

}
