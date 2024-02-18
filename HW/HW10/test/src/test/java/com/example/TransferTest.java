package com.example;

import com.example.exceptions.AccountNotFoundException;
import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class TransferTest {
    @Mock
    public AccountRepository accountRepository;
    @InjectMocks
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
        transferService.transferMoney(1,2,new BigDecimal(100));

//        Проверка

        verify(accountRepository).changeAmount(1,new BigDecimal(900));
        verify(accountRepository).changeAmount(2,new BigDecimal(1000));
    }
    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1L))
                .willReturn(Optional.of(sender));

        given(accountRepository.findById(2L))
                .willReturn(Optional.empty());

        assertThrows(
                AccountNotFoundException.class,
                () -> transferService.transferMoney(1, 2, new BigDecimal(100))
        );

        verify(accountRepository, never())
                .changeAmount(anyLong(), any());
    }
}
