package com.bank.app.controller;

import com.bank.app.model.Account;
import com.bank.app.model.Transaction;
import com.bank.app.security.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;


    @GetMapping("/fromAccount")
    public Transaction findByFromAccount(Account fromAccount) {
        try {
            log.info("attempting to find transaction by fromAccount: {}", fromAccount);
            return transactionService.findByFromAccount(fromAccount);
        } catch (Exception e) {
            log.error("Error while finding transaction by from account: {}", fromAccount, e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/toAccount")
    public Transaction findByToAccount(Account toAccount) {
        try {
            log.info("attempting to find transaction by toAccount: {}", toAccount);
            return transactionService.findByToAccount(toAccount);
        } catch (Exception e) {
            log.error("Error while finding transaction by to account: {}", toAccount, e);
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/fromAccount")
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

    @DeleteMapping("/delete/toAccount")
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

    @PostMapping("/create")
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
