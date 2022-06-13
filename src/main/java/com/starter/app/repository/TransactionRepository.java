package com.starter.app.repository;

import com.starter.app.model.Account;
import com.starter.app.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {

    Transaction findByFromAccount(Account fromAccount);

    Transaction findByToAccount(Account toAccount);

    void deleteByFromAccount(Account fromAccount);

    void deleteByToAccount(Account toAccount);


}
