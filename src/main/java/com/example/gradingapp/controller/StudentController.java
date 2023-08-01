package com.example.gradingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.example.gradingapp.model.Student;
import com.example.gradingapp.service.StudentService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getStudent(@RequestParam Optional<String> name,
            @RequestParam Optional<String> surname) {
        if (name.isPresent() && surname.isPresent()) {
            return new ResponseEntity<>(studentService.getByNameAndSurname(name.get(), surname.get()), null,
                    HttpStatus.OK);
        } else
            return new ResponseEntity<List<Student>>(studentService.getStudents(), null, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Student> getStudentByIndex(@RequestParam Optional<String> index) {
        return new ResponseEntity<>(studentService.getByIndexNumber(index.get()), null,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudent(id), null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), null, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.createStudent(student), null, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<HttpStatus>(null, null, HttpStatus.NO_CONTENT);
    }

}
