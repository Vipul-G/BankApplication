package com.prafful.bank.BankApplication.Branch;

import com.prafful.bank.BankApplication.Bank.Bank;
import com.prafful.bank.BankApplication.Bank.BankService;
import com.prafful.bank.BankApplication.Customer.Account;
import com.prafful.bank.BankApplication.Customer.AccountRepository;
import com.prafful.bank.BankApplication.Loan.Loan;
import com.prafful.bank.BankApplication.Loan.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BranchService {

    @Autowired private BranchRepository branchRepository;
    @Autowired private BankService bankService;
    @Autowired private LoanRepository loanRepository;
    @Autowired private AccountRepository accountRepository;
    private Bank bank = null;

    public BankBranch addBranch(BankBranch branch) {
        this.bank = bankService.getBank();
        bank.addBranch(branch);
        branch.setBank(this.bank);
        return branchRepository.save(branch);
    }

    public String addLoan(Loan loan, int accountId) {
        Account account = accountRepository.getOne(accountId);
        BankBranch branch = account.getBankBranch();
        branch.addLoan(loan);
        account.setLoan(loan);
        loan.setAccount(account);
        loan.setInterest(8.55);
        Loan newLoan = loanRepository.save(loan);
        return loan.getAccount().getName() + "'s loan request of amount " + loan.getAmount() +
                " has been send to the branch manager";
    }


}
