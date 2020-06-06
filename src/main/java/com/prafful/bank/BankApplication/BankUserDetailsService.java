package com.prafful.bank.BankApplication;

import com.prafful.bank.BankApplication.User.User;
import com.prafful.bank.BankApplication.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        int userId = Integer.parseInt(userName);
        Optional<User> user = userRepository.findById(userId);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userId));

        return user.map(BankUserDetails::new).get();
    }

}
