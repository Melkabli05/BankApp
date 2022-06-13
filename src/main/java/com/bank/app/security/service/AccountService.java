package com.bank.app.security.service;

import com.bank.app.model.Account;
import com.bank.app.model.User;

public interface AccountService {

    Account findByName(String name);

    Account findByUserId(User userId);

    void deleteByUserId(User userId);

    void deleteByName(String name);

    Account createAccount(Account account);



}
