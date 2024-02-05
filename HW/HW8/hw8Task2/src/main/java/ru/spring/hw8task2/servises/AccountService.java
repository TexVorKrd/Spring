package ru.spring.hw8task2.servises;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hw8task2.dto.TransferRequest;
import ru.spring.hw8task2.exceptions.TransferException;
import ru.spring.hw8task2.model.Account;
import ru.spring.hw8task2.model.MoneyTransaction;
import ru.spring.hw8task2.repository.AccountRep;
import ru.spring.hw8task2.repository.TransactionRep;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Getter
public class AccountService {

    private final AccountRep accountRep;
    private final TransactionRep transactionRep;

    public AccountService(AccountRep accountRep, TransactionRep transactionRep) {
        this.accountRep = accountRep;
        this.transactionRep = transactionRep;

        //Автонаполнение
        accountRep.save(new Account(0L,"Пертов",new BigDecimal(1000)));
        accountRep.save(new Account(0L,"Баширов>",new BigDecimal(1000)));
        accountRep.save(new Account(0L,"Иванова",new BigDecimal(1000)));
        accountRep.save(new Account(0L,"Степанов",new BigDecimal(1000)));
    }


    @Transactional
    public MoneyTransaction moneyTransfer(TransferRequest dto) throws TransferException {

        //Обработка нестандартных ситуаций
        if (dto == null
                || dto.getSenderAccountId() <= 0
                || dto.getReceiverAccountId() <= 0
                || dto.getAmount() == null
                || dto.getAmount().compareTo(new BigDecimal(0)) <= 0
        ) throw new TransferException("Некорректные данные");

        Optional<Account> optionalSender;
        Optional<Account> optionalReceiver;

        try {
            optionalSender = accountRep.findById(dto.getSenderAccountId());
            optionalReceiver = accountRep.findById(dto.getReceiverAccountId());

        } catch (RuntimeException e) {
            throw new TransferException("Не удалось плучить данные из БД");
        }

        if (optionalSender.isEmpty() || optionalReceiver.isEmpty())
            throw new TransferException("Не удалось получить аккаунты");

        Account sender = optionalSender.get();
        Account receiver = optionalReceiver.get();

        if (sender.getAmount().compareTo(dto.getAmount()) <= 0)
            throw new TransferException("У отправителя недостаточно денег");


        if (sender.getId()==receiver.getId())
            throw new TransferException("Счета совпадают");

        sender.setAmount(sender.getAmount().subtract(dto.getAmount()));
        receiver.setAmount(receiver.getAmount().add(dto.getAmount()));
        accountRep.save(sender);

        //Рандомно генерируемая ошибка для проверки аннотации
         Random random = new Random();
        if (random.nextInt(101)>70)
            throw new TransferException("Рандомно сгенерированная ошибка");

        accountRep.save(receiver);


        MoneyTransaction transaction = new MoneyTransaction();

        transaction.setAccountSender(sender.getId());
        transaction.setAccountReceiver(receiver.getId());
        transaction.setAmount(dto.getAmount());

        transactionRep.save(transaction);

        return transaction;
    }

    public List<Account> findAllAccounts(){
        return accountRep.findAll();
    }
}
