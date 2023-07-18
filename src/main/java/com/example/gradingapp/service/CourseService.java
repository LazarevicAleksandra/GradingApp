package com.example.gradingapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gradingapp.model.Course;

@Service
public class CourseService implements CourseServiceInterface {

    @Override
    public List<Course> getCourses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourses'");
    }

    @Override
    public Course getCourse(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourse'");
    }

    @Override
    public Course saveCourse(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCourse'");
    }

    @Override
    public void deleteCourse(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
    }

}
