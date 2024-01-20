package com.example.demo.repositories;

import com.example.demo.model.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
;
    public User save(User user);
    public void deleteById(int id);

    public void updateById(User user);

    public List<User> getUserById(int id) ;
}
