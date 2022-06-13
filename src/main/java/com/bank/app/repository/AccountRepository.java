package com.bank.app.repository;

import com.bank.app.model.Account;
import com.bank.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, Long> {

    Account findByUserId(User userId);

    Account findByName(String name);

    void deleteByUserId(User userId);


}
