package com.prafful.bank.BankApplication;

import com.prafful.bank.BankApplication.Customer.Account;

import javax.persistence.*;

@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int amount;
    private double interest;

    @OneToOne
    @JoinColumn(name = "AccountId")
    private Account account;

    public Loan(int amount, double interest, Account account) {
        this.amount = amount;
        this.interest = interest;
        this.account = account;
    }
    public Loan() {}

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", interest=" + interest +
                ", account=" + account +
                '}';
    }
}
