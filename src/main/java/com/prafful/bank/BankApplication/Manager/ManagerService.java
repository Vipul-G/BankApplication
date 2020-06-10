package com.prafful.bank.BankApplication.Manager;

import com.prafful.bank.BankApplication.Branch.BankBranch;
import com.prafful.bank.BankApplication.Branch.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private BranchRepository branchRepository;

    //add manager to branch
    public Manager addManager(Manager manager, int branchId) {
        BankBranch branch = branchRepository.getOne(branchId);
        manager.setRole("MANAGER");
        manager.setActive(true);
        branch.setManager(manager);
        manager.setBankBranch(branch);
        return managerRepository.save(manager);
    }

    //delete manager
    public void deleteManager(int id) {
        Manager manager = managerRepository.getOne(id);
        BankBranch branch = manager.getBankBranch();
        branch.setManager(null);
        manager.setBankBranch(null);
        managerRepository.deleteById(id);
    }
}
