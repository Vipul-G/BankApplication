package com.prafful.bank.BankApplication.Bank;


import com.prafful.bank.BankApplication.Admin.Admin;
import com.prafful.bank.BankApplication.Branch.BankBranch;
import com.prafful.bank.BankApplication.Exceptions.BranchNotFoundException;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id = 1111;

    private String name = "PRAFFUL BANK";
    private int totalCustomers = 0;
    private int totalBranches = 0;
    private int totalCapital = 0;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "headquarterId")
    private BankBranch headquarter = null;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bank"
    ) private List<BankBranch> branchList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private static Admin admin;

    Bank() {
    }

    //Branches
    public void addBranch(BankBranch branch) {
        this.branchList.add(branch);
        this.totalBranches = this.branchList.size();
    }
    public List<BankBranch> getBranchList() {
        return this.branchList;
    }
    public BankBranch getBranch(Integer branchId) throws HttpClientErrorException {
        Stream<BankBranch> stream = this.branchList.stream()
                .filter((branch) -> branch.getId().equals(branchId));
        Optional<BankBranch> branch = stream.findFirst();
        branch.orElseThrow(() -> new BranchNotFoundException(branchId));
        return branch.get();
    }
    public BankBranch getBranch(String branchName) throws HttpClientErrorException {
        Stream<BankBranch> stream = this.branchList.stream()
                .filter((branch) -> branch.getName().equals(branchName));
        Optional<BankBranch> branch = stream.findFirst();
        branch.orElseThrow(() -> new BranchNotFoundException(branchName));
        return branch.get();
    }


    // Methods to draw and add the capital by branch
    public final void addCapital(int capital) {
        totalCapital += capital;
    }
    public final int withDrawCapital(int amount) {
        if(amount <= totalCapital) {
            totalCapital -= amount;
            return amount;
        }
        return -1;
    }

    public static Admin getAdmin() {
        return admin;
    }

    public static void setAdmin(Admin admin) {
        Bank.admin = admin;
    }

    public Integer getBankId() {
        return id;
    }

    public void setBankId(Integer bankId) {
        this.id = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers += totalCustomers;
    }

    public int getTotalBranches() {
        return totalBranches;
    }

    public void setTotalBranches(int totalBranches) {
        this.totalBranches = totalBranches;
    }

    public int getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(int totalCapital) {
        this.totalCapital = totalCapital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BankBranch getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(BankBranch headquarter) {
        this.headquarter = headquarter;
    }
}
