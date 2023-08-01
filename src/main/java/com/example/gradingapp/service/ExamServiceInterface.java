
package com.example.gradingapp.service;

import java.util.List;

import com.example.gradingapp.model.Exam;

public interface ExamServiceInterface {
    List<Exam> getExams();

    Exam getExam(Long id);

    Exam createExam(Exam exam);

    Exam updateExam(Exam examm, Long Id);

    void deleteExam(Long id);

    Exam getByStudentIdAndCourseId(Long studentId, Long courseId);

}
