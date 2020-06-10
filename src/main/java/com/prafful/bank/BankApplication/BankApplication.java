package com.prafful.bank.BankApplication;

import com.prafful.bank.BankApplication.Admin.AdminRepository;
import com.prafful.bank.BankApplication.Bank.BankRepository;
import com.prafful.bank.BankApplication.Branch.BranchRepository;
import com.prafful.bank.BankApplication.Customer.AccountRepository;
import com.prafful.bank.BankApplication.Loan.LoanRepository;
import com.prafful.bank.BankApplication.Manager.ManagerRepository;
import com.prafful.bank.BankApplication.User.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
		UserRepository.class,
		AdminRepository.class,
		BankRepository.class,
		BranchRepository.class,
		ManagerRepository.class,
		AccountRepository.class,
		LoanRepository.class
})
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		System.out.println("************I am working fine*************");
	}

}
