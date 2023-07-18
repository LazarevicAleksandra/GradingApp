package com.example.gradingapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gradingapp.model.Student;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    public List<Student> getStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudents'");
    }

    @Override
    public Student getStudent(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudent'");
    }

    @Override
    public Student saveStudent(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveStudent'");
    }

    @Override
    public void deleteStudent(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }

}
