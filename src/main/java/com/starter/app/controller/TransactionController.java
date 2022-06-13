package com.starter.app.controller;

import com.starter.app.model.Account;
import com.starter.app.model.Transaction;
import com.starter.app.security.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j @RestController @RequiredArgsConstructor

@RequestMapping("/api/v1/transaction")
public class TransactionController {

    public final TransactionService transactionService;


    @RequestMapping("/from")
    public Transaction findByFromAccount(Account fromAccount) {
        try {
            log.info("attempting to find transaction by fromAccount: {}", fromAccount);
            return transactionService.findByFromAccount(fromAccount);
        } catch (Exception e) {
            log.error("Error while finding transaction by from account: {}", fromAccount, e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/to")
    public Transaction findByToAccount(Account toAccount) {
        try {
            log.info("attempting to find transaction by toAccount: {}", toAccount);
            return transactionService.findByToAccount(toAccount);
        } catch (Exception e) {
            log.error("Error while finding transaction by to account: {}", toAccount, e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete/from")
    public void deleteByFromAccount(Account fromAccount) {
        try {
            log.info("attempting to delete transaction by fromAccount: {}", fromAccount);
            Transaction transaction = transactionService.findByFromAccount(fromAccount);
            if (transaction != null) {
                transactionService.deleteByFromAccount(fromAccount);
                log.info("transaction deleted by fromAccount: {}", fromAccount);
            }
        } catch (Exception e) {
            log.error("Error while deleting transaction by from account: {}", fromAccount, e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete/to")
    public void deleteByToAccount(Account toAccount) {
        try {
            log.info("attempting to delete transaction by toAccount: {}", toAccount);
            Transaction transaction = transactionService.findByToAccount(toAccount);
            if (transaction != null) {
                transactionService.deleteByToAccount(toAccount);
                log.info("transaction deleted by toAccount: {}", toAccount);
            }
        } catch (Exception e) {
            log.error("Error while deleting transaction by to account: {}", toAccount, e);
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/create")
    public Transaction createTransaction(Transaction transaction) {
        try {
            log.info("attempting to create transaction: {}", transaction);
            return transactionService.createTransaction(transaction);
        } catch (Exception e) {
            log.error("Error while creating transaction: {}", transaction, e);
            throw new RuntimeException(e);
        }
    }



}
