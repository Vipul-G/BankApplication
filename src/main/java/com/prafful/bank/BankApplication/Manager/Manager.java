package com.prafful.bank.BankApplication.Manager;


import com.prafful.bank.BankApplication.Bank;
import com.prafful.bank.BankApplication.Customer.Account;
import com.prafful.bank.BankApplication.User;

import javax.persistence.*;

@Entity
@Table(name = "Manager")
@PrimaryKeyJoinColumn(name="id")
public class Manager extends User {

    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Bank bankBranch;

    public Manager(String name, String password) {
        super(password, "MANAGER");
        this.name = name;
    }

    public Bank getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(Bank bankBranch) {
        this.bankBranch = bankBranch;
    }



    public boolean sanctionLoan(Account account, int loanAmount) {

        int allowed_amount = account.getIncome() * 3;

        return loanAmount <= allowed_amount;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}