package com.prafful.bank.BankApplication.Branch;


import com.prafful.bank.BankApplication.Bank.Bank;
import com.prafful.bank.BankApplication.Customer.Account;
import com.prafful.bank.BankApplication.Exceptions.AccountNotFoundException;
import com.prafful.bank.BankApplication.Exceptions.LoanNotFoundException;
import com.prafful.bank.BankApplication.Loan.Loan;
import com.prafful.bank.BankApplication.Manager.Manager;
import com.sun.istack.NotNull;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Entity
@Table(name = "Branch")
public class BankBranch implements BranchInterface {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    private Bank bank;

    @Column(unique = true)
    @NotNull private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Manager manager;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bankBranch"
    ) private List<Account> accountList = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )private List<Loan> loanList = new ArrayList<>();

    private int totalCustomer = 0;
    @Column(name = "Loan") private int totalLoan = 0;

    public BankBranch() { }
    public BankBranch(Bank bank) {
        this.bank = bank;
    }

    //accountList
    public void addAccount(Account account) {
        this.accountList.add(account);
        this.totalCustomer = this.accountList.size();
    }
    public List<Account> getAccountList() {
        return this.accountList;
    }
    public Account getAccount(Integer accountId) throws HttpClientErrorException {
        Stream<Account> stream = this.accountList.stream()
                .filter((account) -> account.getId().equals(accountId));
        Optional<Account> account = stream.findFirst();
        account.orElseThrow(() -> new AccountNotFoundException(accountId));
        return account.get();
    }

    //loanList
    public void addLoan(Loan loan) {
        this.loanList.add(loan);
        this.totalLoan = this.loanList.size();
    }
    public List<Loan> getLoanList() {
        return this.loanList;
    }
    public Loan getLoan(Integer loanId) {
        Stream<Loan> stream = this.loanList.stream()
                .filter((loan) -> loan.getId().equals(loanId));
        Optional<Loan> loan = stream.findFirst();
        loan.orElseThrow(() -> new LoanNotFoundException(loanId));
        return loan.get();
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
                ", manager=" + (manager == null ? null : manager.getName()) +
                ", totalCustomer=" + totalCustomer +
                ", Bank=" + (bank == null ? null : bank.getName())+
                '}';
    }


}
