package com.prafful.bank.BankApplication.Admin;

import com.prafful.bank.BankApplication.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/admin")
    String addUser(@RequestBody Admin admin) {
        System.out.println(admin);
        try {
            adminService.addAdmin(admin);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return admin.getName() + " Added";
    }

    @GetMapping("/admin/{id}")
    Admin getAdmin(@PathVariable int id) {
        return adminService.getAdmin(id);
    }

    @GetMapping("/admin")
    public String home() {
        return "<h1>Admin Controller</h1>";
    }
    /*
    * Admin can generate new Branch
    * Admin can set headquarter of a Bank
    * Admin can generate new Manager for a Branch
    * Admin can see Bank's internal details
    * */
}
