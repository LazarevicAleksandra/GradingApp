package com.example.gradingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gradingapp.exceptions.ResourceNotFoundException;
import com.example.gradingapp.model.Student;
import com.example.gradingapp.model.Teacher;
import com.example.gradingapp.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return checkStudent(student);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        } else
            throw new ResourceNotFoundException();
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else
            throw new ResourceNotFoundException();
    }

    private Student checkStudent(Optional<Student> student) {
        if (student.isPresent()) {
            return student.get();
        } else
            throw new ResourceNotFoundException();
    }

    @Override
    public List<Student> getByNameAndSurname(String name, String surname) {
        return studentRepository.findByNameAndSurnameContainingIgnoreCase(name, surname);
    }

    @Override
    public List<Student> getByIndexNumber(String index) {
        return studentRepository.findByIndexNumberContainingIgnoreCase(index);
    }
}
