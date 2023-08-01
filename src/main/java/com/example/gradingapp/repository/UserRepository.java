package com.example.gradingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.gradingapp.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
