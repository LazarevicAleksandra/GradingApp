
package com.example.gradingapp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.gradingapp.model.Exam;

public interface ExamServiceInterface {
    List<Exam> getExams();

    Exam getExam(Long id);

    Exam createExam(Exam exam);

    Exam updateExam(Exam examm, Long Id);

    @Transactional
    void deleteExam(Long id);

    Exam getByStudentIdAndCourseId(Long studentId, Long courseId);

}
