package com.prafful.bank.BankApplication.Bank;

import com.prafful.bank.BankApplication.Admin.Admin;
import com.prafful.bank.BankApplication.Admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {

    @Autowired
    private BankRepository bankRepository;
    @Autowired private AdminRepository adminRepository;

    Bank createBank(Bank bank) {
        Admin admin = adminRepository.findAll().get(0);
        bank.setAdmin(admin);
        admin.setBank(bank);
        return bankRepository.save(bank);
    }

    @Transactional(readOnly = true)
    public Bank getBank() {
        return bankRepository.findAll().get(0);
    }
}
