package com.bank.app.security.service;

import com.bank.app.model.Transaction;
import com.bank.app.model.Account;

public interface TransactionService {



      Transaction findByFromAccount(Account fromAccount);

     Transaction findByToAccount(Account toAccount);

     void deleteByFromAccount(Account fromAccount);

     void deleteByToAccount(Account toAccount);

        Transaction createTransaction(Transaction transaction);





}
