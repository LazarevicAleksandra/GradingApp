package com.example.gradingapp.service;

import java.util.List;

import com.example.gradingapp.model.Teacher;

import jakarta.transaction.Transactional;

public interface TeacherServiceInterface {
    List<Teacher> getTeachers();

    Teacher getTeacher(Long id);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    @Transactional
    void deleteTeacher(Long id);

}
