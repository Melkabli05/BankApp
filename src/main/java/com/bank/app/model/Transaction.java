package com.bank.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document @Data @AllArgsConstructor
public class Transaction {

    @Id
    private Long id;
    @DBRef(lazy = true)
   private Account fromAccount;
    @DBRef(lazy = true)
    private Account toAccount;

    private Long amount;

    private TransactionStatus status;

    @CreatedDate
    private LocalDateTime createdAt;




}
