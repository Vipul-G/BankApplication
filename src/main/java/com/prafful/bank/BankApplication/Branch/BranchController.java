package com.prafful.bank.BankApplication.Branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {

    @Autowired private BranchService branchService;

    @PostMapping("/branch")
    String addBranch(@RequestBody BankBranch branch) {
        branchService.addBranch(branch);
        return "Branch " + branch.getName() + " has been added";
    }

}
