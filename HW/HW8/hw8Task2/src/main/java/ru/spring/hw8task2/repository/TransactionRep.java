package ru.spring.hw8task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.hw8task2.model.MoneyTransaction;

@Repository
public interface TransactionRep extends JpaRepository<MoneyTransaction,Long> {
}
