package com.prafful.bank.BankApplication.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {
    //
//* Manager can get his/her details that were specified by an Admin.
//* Manager can get his/her Branch's details
//* Manager can sanction loan
//*
    @Autowired
    private ManagerService managerService;

    @PostMapping("/branch/{id}/manager")
    String addManager(@RequestBody Manager manager,
                      @PathVariable int id) {
        Manager newManager = managerService.addManager(manager, id);
        return "Manager " + newManager.getName() + " has been added";
    }

    @DeleteMapping("/manager/{id}")
    String deleteManager(@PathVariable int id) {
        managerService.deleteManager(id);
        return "Manager has been deleted";
    }
}
