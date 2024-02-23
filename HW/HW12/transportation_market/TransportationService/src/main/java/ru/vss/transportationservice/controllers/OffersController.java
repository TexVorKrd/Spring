package ru.vss.transportationservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transportationService")
public class OffersController {

    @GetMapping()
    public String home(){
        return "Управление предложениями";
    }

    @GetMapping("/test")
    public String test(){
        return "Управление пользователями - тест2";
    }
}
