package com.prafful.bank.BankApplication.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
   List<User> findByRole(String role);
   List<User> findByActive(boolean active);

   @Modifying
   @Query("update User u set u.active=?1, u.role=?2, u.password=?3 where u.id=?4")
   void updateUser(boolean active, String role, String password, int userId);
}
