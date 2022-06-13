package com.bank.app.repository;

import com.bank.app.model.Account;
import com.bank.app.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {

    Transaction findByFromAccount(Account fromAccount);

    Transaction findByToAccount(Account toAccount);

    void deleteByFromAccount(Account fromAccount);

    void deleteByToAccount(Account toAccount);


}
