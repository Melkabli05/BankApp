# Spring Boot Bank app
 
## Technologies 
- Spring Boot (v2.3.3)
- Spring Validation
- Spring Security + JWT Token
- MongDb
- Mapstruct
- Lombok
- Swagger

# Spring Boot Bank app

## Technologies
- Spring Boot (v2.3.3)
- Spring Validation
- Spring Security + JWT Token
- MongDb
- Mapstruct
- Lombok
- Swagger

# bank app transactions

    ## Transactions
    - Create a new transaction
    - Get all transactions
    - Get a transaction by id
    - Update a transaction
    - Delete a transaction

    ## Users
    - Create a new user
    - Get all users
    - Get a user by id
    - Update a user
    - Delete a user

    ## Accounts
    - Create a new account
    - Get all accounts
    - Get an account by id
    - Update an account
    - Delete an account

# bank app schema

    ## Transactions
    - id: Long
    - amount: BigDecimal
    - description: String
    - date: LocalDateTime
    - fromAccountId: Long is the id of the account from which the transaction was made
    - toAccountId: Long is the id of the account to which the transaction was made
    - status: boolean
    

    ## Users
    - id: Long
    - name: String
    - email: String 
    - password: String

    ## Accounts
    - id: Long
    - name: String
    - balance: BigDecimal
    - userId: Long


# bank app security

    ## JWT Token
    - JWT Token is a JSON Web Token (JWT) that is used to authenticate users.
    - JWT Token is a JSON Web Signature (JWS) that is used to sign and verify JSON Web Tokens.
    - JWT Token is a JSON Web Encryption (JWE) that is used to encrypt and decrypt JSON Web Tokens.

    ## Spring Security + JWT Token
    - Spring Security is a Java framework that provides a framework for building secure applications.
    - Spring Security provides a set of authentication and authorization services.