package com.example.gradingapp.model;

import java.util.Date;

import org.hibernate.validator.constraints.Range;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @SequenceGenerator(name = "EXAM_ID_GENERATOR", sequenceName = "Exam_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_ID_GENERATOR")
    private Long Id;

    @NonNull
    @Range(min = 0, max = 100)
    private Integer score;

    @NonNull
    @Range(min = 5, max = 10)
    private Integer grade;

    @NonNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    public Exam() {
    }

    public Exam(Long Id, Integer score, Integer grade, Date date, Student student) {
        this.Id = Id;
        this.score = score;
        this.grade = grade;
        this.date = date;
        this.student = student;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGrade() {
        return this.grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
