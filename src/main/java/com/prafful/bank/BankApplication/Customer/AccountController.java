package com.prafful.bank.BankApplication.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    /*
    * Add money
    * withdraw money
    * transfer money
    * take loan
    * */

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/branch/{branchId}")
    String addAccount(@RequestBody Account account, @PathVariable int branchId) {
        Account newAccount = accountService.creatAccount(account, branchId);
        return "Account " + newAccount.getName() + " has been added";
    }

    @PutMapping("/account/send/{senderId}/to/{receiverId}")
    String sendMoney(
            @RequestParam int amount,
            @PathVariable int senderId,
            @PathVariable int receiverId) {
        return accountService.sendMoney(senderId, receiverId, amount);
    }

    @PutMapping("/account/{accountId}/addMoney")
    String addMoney(
            @PathVariable int accountId,
            @RequestParam int amount
    ) {
        int balance = accountService.addMoney(accountId, amount);
        return "Amount " + amount + " has been added." +
                " Current balance is " + balance;
    }
    
    @PostMapping("/account/{accountId}/loan")
    String takeLoan(
            @PathVariable int accountId,
            @RequestParam int amount
    ) {
        return accountService.takeLoan(accountId, amount);
    }

}
