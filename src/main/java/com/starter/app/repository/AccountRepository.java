package com.starter.app.repository;

import com.starter.app.model.Account;
import com.starter.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, Long> {

    Account findByUserId(User userId);

    Account findByName(String name);

    void deleteByUserId(User userId);


}
