package com.bank.app.security.service;

import com.bank.app.model.Transaction;
import com.bank.app.repository.TransactionRepository;
import com.bank.app.model.Account;
import com.bank.app.model.TransactionStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {


    public final TransactionRepository transactionRepository;


    /**
     * @param fromAccount
     * @return
     */
    @Override
    public Transaction findByFromAccount(Account fromAccount) {
        try {
            log.info("attempting to find transaction by fromAccount: {}", fromAccount);
            return transactionRepository.findByFromAccount(fromAccount);
        } catch (Exception e) {
            log.error("Error while finding transaction by from account: {}", fromAccount, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param toAccount
     * @return
     */
    @Override
    public Transaction findByToAccount(Account toAccount) {
        try {
            log.info("attempting to find transaction by toAccount: {}", toAccount);
            return transactionRepository.findByToAccount(toAccount);
        } catch (Exception e) {
            log.error("Error while finding transaction by to account: {}", toAccount, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param fromAccount
     */
    @Override
    public void deleteByFromAccount(Account fromAccount) {
        try {
            log.info("attempting to delete transaction by fromAccount: {}", fromAccount);
            Transaction transaction = transactionRepository.findByFromAccount(fromAccount);
            if (transaction != null) {
                transactionRepository.delete(transaction);
                log.info("transaction deleted by fromAccount: {}", fromAccount);
            } else {
                log.info("no transaction found by fromAccount: {}", fromAccount);
            }

        } catch (Exception e) {
            log.error("Error while deleting transaction by from account: {}", fromAccount, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param toAccount
     */
    @Override
    public void deleteByToAccount(Account toAccount) {
        try {
            log.info("attempting to delete transaction by toAccount: {}", toAccount);
            Transaction account = transactionRepository.findByToAccount(toAccount);

            if (account != null) {
                transactionRepository.deleteByToAccount(toAccount);
                log.info("deleted transaction by toAccount: {}", toAccount);
            } else {
                log.info("No transaction found for toAccount: {}", toAccount);
            }

        } catch (Exception e) {
            log.error("Error while deleting transaction by to account: {}", toAccount, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * @param transaction
     * @return
     */
    @Override
    public Transaction createTransaction(Transaction transaction) {
        try {
            log.info("attempting to create transaction: {}", transaction);
            transaction.setStatus(TransactionStatus.PENDING);

            Account fromAccount = transaction.getFromAccount();
            Account toAccount = transaction.getToAccount();

            fromAccount.setBalance(fromAccount.getBalance() - transaction.getAmount());
            log.info("editing from account: {}", fromAccount);
            toAccount.setBalance(toAccount.getBalance() + transaction.getAmount());
            log.info("adding to account: {}", toAccount);
            transaction.setStatus(TransactionStatus.SUCCESS);
            return transactionRepository.save(transaction);
        } catch (Exception e) {
            transaction.setStatus(TransactionStatus.FAILED);
            log.error("Error while creating transaction: {}", transaction, e);
            throw new RuntimeException(e);
        }
    }
}
