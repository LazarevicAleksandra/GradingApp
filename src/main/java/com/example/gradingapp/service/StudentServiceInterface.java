package com.example.gradingapp.service;

import java.util.List;

import com.example.gradingapp.model.Student;

public interface StudentServiceInterface {
    List<Student> getStudents();

    Student getStudent(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

}
