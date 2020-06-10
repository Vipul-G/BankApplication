package com.prafful.bank.BankApplication.Exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(int accountId) {
        super("Account not found with id " + accountId);
    }
}
