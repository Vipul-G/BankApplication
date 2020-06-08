package com.prafful.bank.BankApplication.Exceptions;

public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException(Integer id) {
        super("Could not found branch with id " + id);
    }
    public BranchNotFoundException(String name) {
        super("Could not found branch with id " + name);
    }

}
