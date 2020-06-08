package com.prafful.bank.BankApplication.Branch;


import com.prafful.bank.BankApplication.Bank.Bank;
import com.prafful.bank.BankApplication.Customer.Account;
import com.prafful.bank.BankApplication.Loan;
import com.prafful.bank.BankApplication.Manager.Manager;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Branch")
public class BankBranch implements BranchInterface {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Bank bank;

    @NotNull private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Manager manager;

    private int totalCustomer;


    public BankBranch() { }
    public BankBranch(Bank bank) {
        this.bank = bank;
    }

    @Override public BankBranch getHeadquarter() {
        return bank.getHeadquarter();
    }
    @Override public void setHeadquarter() {
        bank.setHeadquarter(this);
    }

    @Override
    public void addCapital(int balance) {
        bank.addCapital(balance);
    }
    @Override
    public int withDrawCapital(int amount) {
        return bank.withDrawCapital(amount);
    }

    public void setTotalCustomer(int totalCustomer) {
        this.totalCustomer += totalCustomer;
        this.bank.setTotalCustomers(totalCustomer);
    }
    public int getTotalCustomer() {
        return this.totalCustomer;
    }

    @Override public String getLoan(int amount, Account account) {
        boolean loan_sanctioned = manager.sanctionLoan(account, amount);
        if(!loan_sanctioned) {
           return "Deat " + account.getName() + " your monthly income of"
                   + account.getIncome() + " has not fullfill our criteria"
                   + " of sactioning the loan of amount " + amount + " rupess";
        }

        new Loan(amount, 0, account);

        account.addBalance(bank.withDrawCapital(amount));

        return "Dear " + account.getName() + " your loan of " + amount +
                " rupees has been sanctioned.";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override public String toString() {
        return "BankBranch{" +
                "branch=" + name +
                ", manager=" + manager.getName() +
                ", totalCustomer=" + totalCustomer +
                ", Bank=" + bank.getName()+
                '}';
    }


}
