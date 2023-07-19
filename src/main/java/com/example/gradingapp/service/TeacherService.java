package com.example.gradingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradingapp.exceptions.ResourceNotFoundException;
import com.example.gradingapp.model.Teacher;
import com.example.gradingapp.repository.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService implements TeacherServiceInterface {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getTeachers() {
        return (List<Teacher>) this.teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return checkTeacher(teacher);
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Long id) {

        if (teacherRepository.findById(id) != null) {
            teacher.setId(id);
            return teacherRepository.save(teacher);
        } else
            throw new ResourceNotFoundException();
    }

    @Transactional
    @Override
    public void deleteTeacher(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        } else
            throw new ResourceNotFoundException();
    }

    private Teacher checkTeacher(Optional<Teacher> teacher) {
        if (teacher.isPresent())
            return teacher.get();
        else
            throw new ResourceNotFoundException();
    }

    public List<Teacher> getTeacherByNameAndSurname(String name, String surname) {
        return teacherRepository.findByNameAndSurnameContainingIgnoreCase(name, surname);

    }

}
