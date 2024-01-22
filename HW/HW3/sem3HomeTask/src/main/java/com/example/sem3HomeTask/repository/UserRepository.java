package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;

import java.util.List;

public interface UserRepository {

    public User addUser(User user);
    public List<User> getUsers();
}
