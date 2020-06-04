package com.prafful.bank.BankApplication;


import com.prafful.bank.BankApplication.Admin.Admin;
import com.prafful.bank.BankApplication.Customer.Account;

import javax.persistence.*;

@Entity
@Table(name = "Bank")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Bank {

    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public static final String name = "PRAFFUL BANK";
    private static int totalCustomers = 0;
    private static int totalBranches = 0;
    private static int totalCapital = 0;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "headquarterId")
    protected static BankBranch headquarter = null;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private static Admin admin;

    public abstract String getLoan(int amount, Account account);

    Bank() { // constructor for child classes
       totalBranches++;
    }

    Bank(BankBranch headquarter, Admin admin) {
        Bank.headquarter = headquarter;
        Bank.admin = admin;
    }


    // Methods to draw and add the capital by branch
    public void addCapital(int capital) {
        totalCapital += capital;
    }
    public int withDrawCapital(int amount) {
        if(amount <= totalCapital) {
            totalCapital -= amount;
            return amount;
        }
        return -1;
    }

    public abstract BankBranch getHeadquarter();
    public abstract void setHeadquarter(BankBranch headquarter);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public static int getTotalCustomers() {
        return totalCustomers;
    }

    public static void setTotalCustomers(int totalCustomers) {
        Bank.totalCustomers = totalCustomers;
    }

    public static int getTotalBranches() {
        return totalBranches;
    }

    public static void setTotalBranches(int totalBranches) {
        Bank.totalBranches = totalBranches;
    }

    public static int getTotalCapital() {
        return totalCapital;
    }

    public static void setTotalCapital(int totalCapital) {
        Bank.totalCapital = totalCapital;
    }



    public static Admin getAdmin() {
        return admin;
    }

    public static void setAdmin(Admin admin) {
        Bank.admin = admin;
    }
}
