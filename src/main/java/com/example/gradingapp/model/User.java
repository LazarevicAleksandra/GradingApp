package com.example.gradingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "User_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    private Long Id;

    @NotNull
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull
    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotNull
    @NotBlank(message = "Username cannot be blank")
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    @NotBlank(message = "Surname cannot be blank")
    private String password;

    public User() {
    }

    public User(Long Id, String name, String surname, String username, String password) {
        this.Id = Id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
