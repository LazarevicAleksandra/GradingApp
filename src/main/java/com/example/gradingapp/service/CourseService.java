package com.example.gradingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradingapp.exceptions.ResourceNotFoundException;
import com.example.gradingapp.model.Course;
import com.example.gradingapp.model.Teacher;
import com.example.gradingapp.repository.CourseRepository;
import com.example.gradingapp.repository.TeacherRepository;

@Service
public class CourseService implements CourseServiceInterface {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return checkCourse(course);
    }

    @Override
    public Course getCourseByCode(String code) {
        Optional<Course> course = courseRepository.findByCodeContainingIgnoreCase(code);
        return checkCourse(course);
    }

    @Override
    public Course getCourseByName(String name) {
        Optional<Course> course = courseRepository.findByNameContainingIgnoreCase(name);
        return checkCourse(course);
    }

    @Override
    public Course createCourse(Course course) {
        Optional<Teacher> teacher = teacherRepository.findById(course.getTeacher().getId());
        Course savedCourse = courseRepository.save(course);
        if (teacher.isPresent())
            savedCourse.setTeacher(teacher.get());
        return savedCourse;
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        Optional<Teacher> teacher;
        if (optionalCourse.isPresent()) {

            if (course.getTeacher().getId() != null) {
                teacher = teacherRepository.findById(course.getTeacher().getId());
            } else {
                teacher = teacherRepository.findById(optionalCourse.get().getTeacher().getId());
            }
            course.setTeacher(teacher.get());
            course.setId(id);

            return courseRepository.save(course);
        } else
            throw new ResourceNotFoundException();
    }

    @Override
    public void deleteCourse(Long id) {
        if (courseRepository.findById(id) != null) {
            courseRepository.deleteById(id);
        } else
            throw new ResourceNotFoundException();
    }

    private Course checkCourse(Optional<Course> course) {
        if (course.isPresent())
            return course.get();
        else
            throw new ResourceNotFoundException();
    }

    @Override
    public List<Course> getByTeacherId(Long id) {
        return courseRepository.findByTeacherId(id);
    }

}
