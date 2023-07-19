package com.example.gradingapp.service;

import java.util.List;

import com.example.gradingapp.model.Teacher;

import jakarta.transaction.Transactional;

public interface TeacherServiceInterface {
    List<Teacher> getTeachers();

    Teacher getTeacher(Long id);

    List<Teacher> getTeacherByNameAndSurname(String name, String surname);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher, Long id);

    @Transactional
    void deleteTeacher(Long id);

}
