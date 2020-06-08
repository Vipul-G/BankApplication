package com.prafful.bank.BankApplication.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class
    ) Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Transactional(readOnly = true)
    public Bank getBank() {
        return bankRepository.findAll().get(0);
    }
}
