package com.example.gradingapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.gradingapp.model.Exam;

public interface ExamRepository extends CrudRepository<Exam, Long> {
    Optional<Exam> findByStudentIdAndCourseId(Long studentId, Long courseId);

}
