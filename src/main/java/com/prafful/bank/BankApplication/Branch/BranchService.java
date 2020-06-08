package com.prafful.bank.BankApplication.Branch;

import com.prafful.bank.BankApplication.Bank.Bank;
import com.prafful.bank.BankApplication.Bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BranchService {

    @Autowired private BranchRepository branchRepository;
    @Autowired private BankService bankService;
    private Bank bank = null;

    public BankBranch addBranch(BankBranch branch) {
        this.bank = bankService.getBank();
        bank.addBranch(branch);
        branch.setBank(this.bank);
        return branchRepository.save(branch);
    }



}
