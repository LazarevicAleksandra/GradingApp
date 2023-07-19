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

import com.example.gradingapp.model.Teacher;
import com.example.gradingapp.service.TeacherService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("")
    public ResponseEntity<List<Teacher>> getTeachers(@RequestParam Optional<String> name,
            @RequestParam Optional<String> surname) {
        if (name.isPresent() && surname.isPresent()) {
            return new ResponseEntity<>(teacherService.getTeacherByNameAndSurname(name.get(), surname.get()), null,
                    HttpStatus.OK);
        } else
            return new ResponseEntity<List<Teacher>>(teacherService.getTeachers(), null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.getTeacher(id), null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @Valid @RequestBody Teacher teacher) {
        return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher, id), null, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody Teacher teacher) {
        return new ResponseEntity<Teacher>(teacherService.createTeacher(teacher), null, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<HttpStatus>(null, null, HttpStatus.NO_CONTENT);
    }

}