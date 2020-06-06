package com.prafful.bank.BankApplication.User;

import com.prafful.bank.BankApplication.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    String greeter() {
        return "<h1>Authentication Working</h1>";
    }
    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable int userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
    }
    @GetMapping("/users/{role}")
    List<User> getUserByRole(@PathVariable String role) {
        return userRepository.findByRole(role);
    }
    @GetMapping("/users/{active}")
    List<User> getUserByActive(@PathVariable boolean active) {
        return userRepository.findByActive(active);
    }

//    @PutMapping("/user")
//    User updateUser(@RequestBody User user) {
//        Optional<User> existingUser = userRepository.findById(user.getId());
//
//        existingUser.orElseThrow(() -> new UserNotFoundException(user.getId()));
//
//        User existUser = existingUser.get();
//
//        userRepository.updateUser(
//                existUser.getActive(), existUser.getRole(), existUser.getPassword(), existUser.getId());
//
//        return userRepository.findById(existUser.getId()).orElse(null);
//    }

    @DeleteMapping("/user/{userId}")
    boolean deleteUser(@PathVariable int userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

}
