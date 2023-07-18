
package com.example.gradingapp.service;

import java.util.List;

import com.example.gradingapp.model.Exam;

public interface ExamServiceInterface {
    List<Exam> getExams();

    Exam getExam(Long id);

    Exam saveExam(Exam exam);

    void deleteExam(Long id);

}
