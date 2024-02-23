package ru.vss.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userService")
public class UserController {

    @GetMapping()
    public String home(){
        return "Управление пользователями";
    }

    @GetMapping("/test")
    public String test(){
        return "Управление пользователями - тест1";
    }


}
