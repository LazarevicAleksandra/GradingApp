package com.example.gradingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gradingapp.model.Exam;
import com.example.gradingapp.service.ExamService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @GetMapping("")
    public ResponseEntity<List<Exam>> getAllExams(Optional<Long> courseId, Optional<Long> studentId) {
        return new ResponseEntity<List<Exam>>(examService.getExams(), null, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Exam> getExamByParam(@RequestParam Optional<Long> courseId,
            @RequestParam Optional<Long> studentId) {
        return new ResponseEntity<Exam>(examService.getByStudentIdAndCourseId(studentId.get(), courseId.get()), null,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExam(@PathVariable Long id, @RequestParam Optional<String> examName,
            Optional<String> examCode) {
        return new ResponseEntity<Exam>(examService.getExam(id), null, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Exam> createExam(@Valid @RequestBody Exam exam) {
        return new ResponseEntity<Exam>(examService.createExam(exam), null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@Valid @RequestBody Exam exam, @PathVariable Long id) {
        return new ResponseEntity<Exam>(examService.updateExam(exam, id), null, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return new ResponseEntity<HttpStatus>(null, null, HttpStatus.NO_CONTENT);
    }

}
