package ru.veb.web.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.veb.web.servises.WebServices;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class UserController {

    private final WebServices services;

    @GetMapping("/1")
    public String userTest1() {
        return services.test1();
    }

    @GetMapping("/2")
    public String userTest2() {
        return services.test2();
    }

    @GetMapping("/3")
    public String userTest3() {
        return services.test3();
    }

    @GetMapping("/4")
    public String userTest4() {
        return services.test4();
    }

}
