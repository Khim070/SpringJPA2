package com.example.springjpa2.dao;

import com.example.springjpa2.api.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User saveUser(User user);
    User findById(int id);
}
