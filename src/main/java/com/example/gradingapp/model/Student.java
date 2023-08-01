package com.example.gradingapp.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @SequenceGenerator(name = "STUDENT_ID_GENERATOR", sequenceName = "Student_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_GENERATOR")
    private Long id;

    @NotNull
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull
    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotNull
    @NotBlank(message = "Index cannot be blank")
    @Column(nullable = false, unique = true)
    private String indexNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Exam> exams;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student() {
    }

    public Student(Long id, String name, String surname, String indexNumber, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.indexNumber = indexNumber;
        this.courses = courses;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIndexNumber() {
        return this.indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

}
