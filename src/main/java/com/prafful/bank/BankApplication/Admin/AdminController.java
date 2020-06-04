package com.prafful.bank.BankApplication.Admin;

import com.prafful.bank.BankApplication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository adminRepository;

    @GetMapping("")
    public String home() {
        return "<h1>Welcome admin</h1>";
    }

    /*
    * Admin can generate new Branch
    * Admin can set headquarter of a Bank
    * Admin can generate new Manager for a Branch
    * Admin can see Bank's internal details
    * */
}
