package ru.spring.hw8task2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.hw8task2.dto.TransferRequest;
import ru.spring.hw8task2.exceptions.TransferException;
import ru.spring.hw8task2.model.MoneyTransaction;
import ru.spring.hw8task2.servises.AccountService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    /**
     * Транзакция
     * @param dto - информация лоя перевода, кто, кому, сколько
     * @param model - MODEL
     * @return - Страница управления аккаунтом.
     */
    @PostMapping("")
    public String makeTransaction( TransferRequest dto, Model model){

        //Обработка вариантов событий
        try {
            MoneyTransaction transaction =service.moneyTransfer(dto);
            model.addAttribute("msg","Транзакция прошла успешно");
            model.addAttribute("err",false);

        }catch (TransferException e){
            model.addAttribute("msg",e.getMessage());
            model.addAttribute("err",true);
        }catch (Exception e){
            model.addAttribute("msg","Что-то пошло совсе не так");
            model.addAttribute("err",true);
        }finally {
            model.addAttribute("accounts", service.findAllAccounts());
            return "accounts";
        }
    }

    /**
     * Отображение страницы с аккаунтами и функционалом
     *
     * @param model - Модель
     * @return
     */
    @GetMapping()
    public String findAllAccounts(Model model){
        model.addAttribute("accounts", service.findAllAccounts());
        return "accounts";
    }


}
