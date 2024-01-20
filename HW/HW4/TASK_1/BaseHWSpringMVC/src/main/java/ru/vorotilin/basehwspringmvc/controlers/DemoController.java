package ru.vorotilin.basehwspringmvc.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vorotilin.basehwspringmvc.model.User;

import java.util.Random;

@Controller
public class DemoController {

    @GetMapping()
    public String startPage(){
        return "startpage";
    }

    @GetMapping("/task2")
    public String thymeleafSimpleDemo(Model model) {
        model.addAttribute("var", "Any Value");
        model.addAttribute("rnd", new Random().nextInt(1000));
        return "thymeleafSD";
    }

    @GetMapping("/task3")
    public String thymeleafFormShow(Model model) {
        model.addAttribute("fname", "Не Заполнено");
        model.addAttribute("sname", "Не заполнено");
        return "thymeleafForm";
    }

    @PostMapping("/task3")
    public String thymeleafFormUpdate(User user, Model model) {
        model.addAttribute("fname", user.getFname());
        model.addAttribute("sname", user.getSname());
        return "thymeleafForm";
    }



}
