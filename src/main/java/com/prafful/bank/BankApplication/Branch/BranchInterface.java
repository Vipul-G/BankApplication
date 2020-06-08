package com.prafful.bank.BankApplication.Branch;

import com.prafful.bank.BankApplication.Customer.Account;

public interface BranchInterface {
    String getLoan(int amount, Account account);
    BankBranch getHeadquarter();
    void setHeadquarter();

    void addCapital(int balance);

    int withDrawCapital(int amount);
}
