package com.prafful.bank.BankApplication.Exceptions;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(int id) {
        super("Loan with id " + id + " not found");
    }
}
