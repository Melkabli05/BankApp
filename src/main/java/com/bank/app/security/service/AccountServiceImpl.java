package com.bank.app.security.service;

import com.bank.app.model.Account;
import com.bank.app.model.User;
import com.bank.app.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {


    public final AccountRepository accountRepository;

    /**
     * @param name
     * @return
     */
    @Override
    public Account findByName(String name) {
        try {
            log.info("attempting to find account by name: {}", name);
            return accountRepository.findByName(name);
        } catch (Exception e) {
            log.error("Error while finding account by name: {}", name, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Account findByUserId(User userId) {
        try {
            log.info("attempting to find account by userId: {}", userId);
            return accountRepository.findByUserId(userId);
        } catch (Exception e) {
            log.error("Error while finding account by userId: {}", userId, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param userId
     */
    @Override
    public void deleteByUserId(User userId) {
        try {
            log.info("attempting to delete account by userId: {}", userId);
            accountRepository.deleteByUserId(userId);
        } catch (Exception e) {
            log.error("Error while deleting account by userId: {}", userId, e);
            throw new RuntimeException(e);
        }

    }

    /**
     * @param name
     */
    @Override
    public void deleteByName(String name) {
        try {
            log.info("attempting to delete account by name: {}", name);
            Account account = accountRepository.findByName(name);
            if (account != null) {
                accountRepository.delete(account);
                log.info("account deleted by name: {}", name);
            } else {
                log.info("no account found by name: {}", name);
            }

        } catch (Exception e) {
            log.error("Error while deleting account by name: {}", name, e);
            throw new RuntimeException(e);
        }

    }

    /**
     * @param account
     * @return
     */
    @Override
    public Account createAccount(Account account) {
        try {

            Account existingAccount = accountRepository.findByUserId(account.getUserId());
            if (existingAccount != null) {
                log.info("user already has an account: {}", existingAccount);
                return existingAccount;
            }
            log.info("attempting to create account: {}", account);
            return accountRepository.save(account);
        } catch (Exception e) {
            log.error("Error while creating account: {}", account, e);
            throw new RuntimeException(e);
        }
    }
}

