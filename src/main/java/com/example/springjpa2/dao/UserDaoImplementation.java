package com.example.springjpa2.dao;

import com.example.springjpa2.api.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImplementation implements UserDao{
    private EntityManager entityManager;

    @Autowired
    public UserDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u",User.class);
        List<User> result = query.getResultList();
        return result;
    }

    @Override
    public User saveUser(User user) {
        User result = entityManager.merge(user);
        return result;
    }

    @Override
    public User findById(int id) {
        User result = entityManager.find(User.class, id);
        return result;
    }
}
