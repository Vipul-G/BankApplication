package com.prafful.bank.BankApplication.Admin;


import com.prafful.bank.BankApplication.BankBranch;
import com.prafful.bank.BankApplication.Manager.Manager;
import com.prafful.bank.BankApplication.User;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "Admin")
@PrimaryKeyJoinColumn(name="id")
public final class Admin extends User {

    private String name;

    public Admin(String name, String password) {
        super(password, "ADMIN");
        this.name = name;
    }

    /*
     * Admin can generate new Branch
     * Admin can set headquarter of a Bank
     * Admin can generate new Manager for a Branch
     * Admin can see Bank's internal details
     * */

    public BankBranch createBranch(String bName) {
        return new BankBranch(bName);
    }

    public void setHeadquartor(BankBranch branch) {
        branch.setHeadquarter(branch);
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
}
