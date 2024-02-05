package ru.spring.hw8task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.hw8task2.model.Account;

@Repository
public interface AccountRep extends JpaRepository<Account, Long> {
}
