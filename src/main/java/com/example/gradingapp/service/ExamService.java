package com.example.gradingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradingapp.exceptions.ResourceNotFoundException;
import com.example.gradingapp.model.Course;
import com.example.gradingapp.model.Exam;
import com.example.gradingapp.model.Student;
import com.example.gradingapp.repository.CourseRepository;
import com.example.gradingapp.repository.ExamRepository;
import com.example.gradingapp.repository.StudentRepository;

@Service
public class ExamService implements ExamServiceInterface {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Exam> getExams() {
        return (List<Exam>) examRepository.findAll();
    }

    @Override
    public Exam getExam(Long id) {
        return checkExam(examRepository.findById(id));
    }

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Exam exam, Long Id) {
        Optional<Exam> optionalExam = examRepository.findById(Id);
        Optional<Course> course;
        Optional<Student> student;
        if (optionalExam.isPresent()) {

            if (exam.getCourse().getId() != null) {
                course = courseRepository.findById(exam.getCourse().getId());
            } else {
                course = courseRepository.findById(optionalExam.get().getCourse().getId());
            }

            if (exam.getCourse().getId() != null) {
                student = studentRepository.findById(exam.getCourse().getId());
            } else {
                student = studentRepository.findById(optionalExam.get().getCourse().getId());
            }
            exam.setCourse(course.get());
            exam.setStudent(student.get());
            exam.setId(Id);

            return examRepository.save(exam);

        } else
            throw new ResourceNotFoundException();
    }

    @Override
    public void deleteExam(Long id) {
        if (examRepository.existsById(id)) {
            examRepository.deleteById(id);
        } else
            throw new ResourceNotFoundException();
    }

    private Exam checkExam(Optional<Exam> exam) {
        if (exam.isPresent())
            return exam.get();
        else
            throw new ResourceNotFoundException();
    }

    @Override
    public Exam getByStudentIdAndCourseId(Long studentId, Long courseId) {
        return examRepository.findByStudentIdAndCourseId(studentId, courseId);
    }

}
