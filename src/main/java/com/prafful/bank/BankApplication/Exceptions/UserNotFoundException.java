package com.prafful.bank.BankApplication.Exceptions;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(int id) {
        super("Could not find user " + id);
    }
}
