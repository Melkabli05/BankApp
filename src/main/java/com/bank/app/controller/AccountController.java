package com.bank.app.controller;

import com.bank.app.model.Account;
import com.bank.app.model.User;
import com.bank.app.security.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {



    private final AccountService accountService;


    @GetMapping("/name")
    public Account findByName(String name) {
        try {
            log.info("attempting to find account by name: {}", name);
            return accountService.findByName(name);
        } catch (Exception e) {
            log.error("Error while finding account by name: {}", name, e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/userId")
    public Account findByUserId(User userId) {
        try {
            log.info("attempting to find account by userId: {}", userId);
            return accountService.findByUserId(userId);
        } catch (Exception e) {
            log.error("Error while finding account by userId: {}", userId, e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/deleteUserId")
    public void deleteByUserId(User userId) {
        try {
            log.info("attempting to delete account by userId: {}", userId);
            accountService.deleteByUserId(userId);
        } catch (Exception e) {
            log.error("Error while deleting account by userId: {}", userId, e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/deleteName")
    public void deleteByName(String name) {
        try {
            log.info("attempting to delete account by name: {}", name);
            accountService.deleteByName(name);
        } catch (Exception e) {
            log.error("Error while deleting account by name: {}", name, e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/createAccount")
    public Account createAccount(Account account) {
        try {
            log.info("attempting to create account: {}", account);
            return accountService.createAccount(account);
        } catch (Exception e) {
            log.error("Error while creating account: {}", account, e);
            throw new RuntimeException(e);
        }
    }

}
