package com.starter.app.security.service;

import com.starter.app.model.Account;
import com.starter.app.model.User;

public interface AccountService {

    Account findByName(String name);

    Account findByUserId(User userId);

    void deleteByUserId(User userId);

    void deleteByName(String name);

    Account createAccount(Account account);



}
