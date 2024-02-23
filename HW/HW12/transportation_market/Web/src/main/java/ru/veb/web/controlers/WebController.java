package ru.veb.web.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.veb.web.servises.WebServices;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web")
public class WebController {

    private final WebServices services;

    /**
     * Тестовая страница
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String webTest(Model model) {

        model.addAttribute("req3", services.test3());
        model.addAttribute("req4", services.test4());
        model.addAttribute("req1", services.test1());
        model.addAttribute("req2", services.test2());
        return "home";
    }

    @GetMapping("/integration/{msg}")
    public String integrationTest(@PathVariable String msg) {
        services.saveActionToFile(msg);
        return "home";
    }


}
