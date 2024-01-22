package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        return service.tasksList();
    }

    @GetMapping("/sort")
    public List<User> userListSorted() {
        return service.sortUsersByAge();
    }

    @GetMapping("/filter/{age}")
    public List<User> userListFiltredByAge(@PathVariable int age) {
        return service.filterUsersByAge(age);
    }

    @GetMapping("/calc")
    public double userListFiltredByAge() {
        return service.calculateAverageAge();
    }
}
