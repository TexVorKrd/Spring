package ru.spring.hw7task1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    /**
     * Для аутинтефицированых пользователей
     *
     * @return
     */
    @GetMapping("/public-data")
    public String userPage(){
        return "public_page";
    }

    /**
     * Админка.
     *
     * @return
     */
    @GetMapping("/private-data")
    public String adminPage(){
        return "private_page";
    }

    /**
     * Ошибка авторизации.
     *
     * @return
     */
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    /**
     * Аутентификация.
     *
     * @return.
     */
    @GetMapping("/login")
    public String auth(){
        return "login-page";
    }
}
