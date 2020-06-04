package com.prafful.bank.BankApplication;


import com.prafful.bank.BankApplication.Admin.Admin;
import com.prafful.bank.BankApplication.Customer.Account;
import com.prafful.bank.BankApplication.Manager.Manager;

public class BankBranch extends Bank implements Runnable {

    private String name;
    private Manager manager;
    private int totalCustomer;

    public BankBranch(String name) { // primary constructor to create branch
        super();
        this.name = name;
    }

    public BankBranch(BankBranch headquarter, Admin admin){ // if branch is headquarter then call this constructor after primary constructor
        super(headquarter, admin);
    }

    @Override
    public BankBranch getHeadquarter() {
        return Bank.headquarter;
    }
    @Override // Only Admin is Authorized to set headquarters
    public void setHeadquarter(BankBranch headquarter) {
        Bank.headquarter = headquarter;
    }

    @Override
    public String getLoan(int amount, Account account) {
        boolean loan_sanctioned = manager.sanctionLoan(account, amount);
        if(!loan_sanctioned) {
           return "Deat " + account.getName() + " your monthly income of"
                   + account.getIncome() + " has not fullfill our criteria"
                   + " of sactioning the loan of amount " + amount + " rupess";
        }

        new Loan(amount, 0, account);

        account.addBalance(this.withDrawCapital(amount));

        return "Dear " + account.getName() + " your loan of " + amount +
                " rupees has been sanctioned.";
    }

    @Override
    public void run() {
        
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

    public int getTotalCustomer() {
        return totalCustomer;
    }
    public void addCustomers(int totalCustomer) {
        this.totalCustomer += totalCustomer;
    }

    public boolean transferMoney(int amount, int accountNumber) {
        //if account exists

        //if account do not exists
        return false;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "branch=" + name +
                ", manager=" + manager +
                ", totalCustomer=" + totalCustomer +
                '}';
    }


}
