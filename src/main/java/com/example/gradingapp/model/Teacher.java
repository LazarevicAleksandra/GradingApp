package com.example.gradingapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @SequenceGenerator(name = "TEACHER_ID_GENERATOR", sequenceName = "Teacher_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEACHER_ID_GENERATOR")
    private Long id;

    @NotNull
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull
    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @JsonIgnore
    @OneToMany(mappedBy = "teachers")
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(Long id, String name, String surname, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "name='" + getName() + "'" +
                ", surname='" + getSurname() + "'";
    }

}
