package com.prafful.bank.BankApplication.Admin;

import com.prafful.bank.BankApplication.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Transactional(readOnly = true)
    public Admin getAdmin(int adminId) {
        return (adminRepository.findById(adminId)).orElseThrow(
                () -> new UserNotFoundException(adminId)
        );
    }

}
