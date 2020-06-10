package com.prafful.bank.BankApplication.Admin;


import com.prafful.bank.BankApplication.Bank.Bank;
import com.prafful.bank.BankApplication.Branch.BankBranch;
import com.prafful.bank.BankApplication.Manager.Manager;
import com.prafful.bank.BankApplication.User.User;
import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "Admin")
@PrimaryKeyJoinColumn(name="id")
public final class Admin extends User {

    @NotNull private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private Bank bank;

    public Admin(String name, String password) {
        super(password, "ADMIN");
        this.name = name;
    }

    public Admin() { }

    /*
     * Admin can generate new Branch
     * Admin can set headquarter of a Bank
     * Admin can generate new Manager for a Branch
     * Admin can see Bank's internal details
     * */

    public void setHeadquartor(BankBranch branch) {
        branch.setHeadquarter();
    }

    public void setBranchManager(BankBranch branch, String managerName, String managerPassword) {
        Manager manager = new Manager(managerName, managerPassword);
        branch.setManager(manager);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                "role='" + this.getRole() + '\'' +
                "password='" + this.getPassword() + '\'' +
                "active='" + this.getActive() + '\'' +
                '}';
    }
}
