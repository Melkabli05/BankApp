package com.starter.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document @Data
public class Account {

    @Id
    private Long id;
    private String name;
    private Long balance;

    @DBRef(lazy = true)
    private User userId;

}
