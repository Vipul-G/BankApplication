package com.prafful.bank.BankApplication.Admin;

import com.prafful.bank.BankApplication.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/admin")
    String addUser(@RequestBody Admin admin) {
        System.out.println("======Admin Post API hit=======");
        System.out.println(admin);
        try {
            adminService.addAdmin(admin);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return admin.getName() + " Added";
    }

    @GetMapping("/admin")
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
