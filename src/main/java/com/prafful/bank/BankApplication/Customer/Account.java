package com.prafful.bank.BankApplication.Customer;


import com.prafful.bank.BankApplication.Branch.BankBranch;
import com.prafful.bank.BankApplication.Loan.Loan;
import com.prafful.bank.BankApplication.User.User;

import javax.persistence.*;

@Entity
@Table(name = "Account")
@PrimaryKeyJoinColumn(name="id")
public class Account extends User implements Runnable {
    private String name;
    private String contactNumber;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY, optional = false)
    private BankBranch bankBranch;
    private int balance;
    private int income;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Loan loan = null;

    public Account(String name, String password) {
        super(password, "CUSTOMER");
        this.name = name;
        this.balance = 0;
    }

    public Account() { }

    @Override
    public void run() {

    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }
    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public int getBalance() {
        return balance;
    }
    public void addBalance(int balance) {
        this.balance += balance;
        this.bankBranch.addCapital(balance); // storing money into customer's bank branch
    }
    public int withDrawMoney(int amount) {
        if(amount > this.balance) {
            return -1; // insufficient balance in customer's account. Consider loan.
        }
        this.balance -= amount;
        return this.bankBranch.withDrawCapital(amount);
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        BankBranch b = (BankBranch) this.bankBranch;
        return "Account{" +
                "name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", bankBranch=" + b.getName() +
                ", balance=" + balance +
                ", income=" + income +
                '}';
    }
}
