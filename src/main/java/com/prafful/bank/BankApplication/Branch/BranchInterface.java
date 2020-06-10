package com.prafful.bank.BankApplication.Branch;

public interface BranchInterface {
    BankBranch getHeadquarter();
    void setHeadquarter();

    void addCapital(int balance);

    int withDrawCapital(int amount);
}
