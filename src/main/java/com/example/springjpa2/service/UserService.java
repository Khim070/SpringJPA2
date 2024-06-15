package com.example.springjpa2.service;

import com.example.springjpa2.api.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User addUser(User user);
    User updateUser(int id, User user);
    User findById(int id);
}
