package com.starter.app.security.service;

import com.starter.app.model.Account;
import com.starter.app.model.Transaction;

public interface TransactionService {



      Transaction findByFromAccount(Account fromAccount);

     Transaction findByToAccount(Account toAccount);

     void deleteByFromAccount(Account fromAccount);

     void deleteByToAccount(Account toAccount);

        Transaction createTransaction(Transaction transaction);





}
