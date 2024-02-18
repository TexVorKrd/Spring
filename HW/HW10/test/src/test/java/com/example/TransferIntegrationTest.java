package com.example;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;


import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class TransferIntegrationTest {


    @MockBean
    public AccountRepository accountRepository;

    @Autowired
    public TransferService transferService;

    @Test

    public void moneyTransfer(){

//        Предпосылки
        Account account1= new Account();
        account1.setId(1);
        account1.setAmount(new BigDecimal(1000));

        Account account2= new Account();
        account2.setId(2);
        account2.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(account1.getId())).willReturn(Optional.of(account1));
        given(accountRepository.findById(account2.getId())).willReturn(Optional.of(account2));

//        Вызов
        transferService.transferMoney(1,2,new BigDecimal(50));

//        Проверка

        verify(accountRepository).changeAmount(1,new BigDecimal(950));
        verify(accountRepository).changeAmount(2,new BigDecimal(1050));
    }

}
