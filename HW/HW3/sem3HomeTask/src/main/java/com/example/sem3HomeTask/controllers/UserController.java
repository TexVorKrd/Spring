package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<User> userList() {

        return dataProcessingService.usersList();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user);
        return "User added from body!";
    }

    @GetMapping("/addUser")
    public String userList(@RequestParam String name,
                           @RequestParam int age,
                           @RequestParam String email
    ) {

        registrationService.processRegistration(name, age, email);
        return "User added from request!";
    }
}
