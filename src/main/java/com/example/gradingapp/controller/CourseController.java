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

import com.example.gradingapp.model.Course;
import com.example.gradingapp.service.CourseService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("")
    public ResponseEntity<List<Course>> getAllCourses(Optional<Long> teacherId) {
        if (teacherId.isPresent()) {
            return new ResponseEntity<List<Course>>(courseService.getByTeacherId(teacherId.get()), null, HttpStatus.OK);
        } else
            return new ResponseEntity<List<Course>>(courseService.getCourses(), null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id, @RequestParam Optional<String> courseName,
            Optional<String> courseCode) {
        if (courseName.isPresent()) {
            return new ResponseEntity<Course>(courseService.getCourseByName(courseName.get()), null, HttpStatus.OK);
        } else if (courseCode.isPresent()) {
            return new ResponseEntity<Course>(courseService.getCourseByCode(courseCode.get()), null, HttpStatus.OK);
        } else
            return new ResponseEntity<Course>(courseService.getCourse(id), null, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        return new ResponseEntity<Course>(courseService.createCourse(course), null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course, @PathVariable Long id) {
        return new ResponseEntity<Course>(courseService.updateCourse(course, id), null, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<HttpStatus>(null, null, HttpStatus.NO_CONTENT);
    }

}
