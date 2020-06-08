package com.prafful.bank.BankApplication.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
    @Autowired
    BankService bankService;

    @PostMapping("/bank")
    String createBank(@RequestBody Bank bank) {
        Bank newBank = bankService.createBank(bank);
        return newBank.getName() + " has been added successfully";
    }

    @GetMapping("/bank")
    Bank getBank() {
        return bankService.getBank();
    }

}
