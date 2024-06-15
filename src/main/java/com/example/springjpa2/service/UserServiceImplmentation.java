package com.example.springjpa2.service;

import com.example.springjpa2.api.models.User;
import com.example.springjpa2.dao.UserDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplmentation implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServiceImplmentation(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public User addUser(User user) {
        user.setId(0);
        User result = userDao.saveUser(user);
        return result;
    }

    @Transactional
    @Override
    public User updateUser(int id, User user) {
        user.setId(id);
        User result = userDao.saveUser(user);
        return result;
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
}
