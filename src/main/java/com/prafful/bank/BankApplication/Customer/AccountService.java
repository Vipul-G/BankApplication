package com.prafful.bank.BankApplication.Customer;

import com.prafful.bank.BankApplication.Branch.BankBranch;
import com.prafful.bank.BankApplication.Branch.BranchRepository;
import com.prafful.bank.BankApplication.Branch.BranchService;
import com.prafful.bank.BankApplication.Loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired private AccountRepository accountRepository;
    @Autowired private BranchRepository branchRepository;
    @Autowired private BranchService branchService;

    public Account creatAccount(Account account, int branchId) {
        BankBranch branch = branchRepository.getOne(branchId);
        account.setActive(true);
        account.setRole("CUSTOMER");
        if(account.getPassword() == null) {
            account.setPassword("customer");
        }
        branch.addAccount(account);
        account.setBankBranch(branch);
        return accountRepository.save(account);
    }

    public int addMoney(int accountId, int amount) {
        Account account = accountRepository.getOne(accountId);
        account.addBalance(amount);
        return account.getBalance();
    }

    public String sendMoney(int senderId, int receiverId, int amount) {
        Account sender = accountRepository.getOne(senderId);
        Account receiver = accountRepository.getOne(receiverId);
        int money = sender.withDrawMoney(amount);
        if(money == -1) {
            return "Insufficient balance";
        }
        receiver.addBalance(money);

        return "Amount " + amount + " has been send from " +
                sender.getName() + "to " + receiver.getName();
    }

    public String takeLoan(int accountId, int amount) {
        Loan loan = new Loan(amount);
        return branchService.addLoan(loan, accountId);
    }
}
