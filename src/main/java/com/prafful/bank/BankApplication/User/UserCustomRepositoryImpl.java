//package com.prafful.bank.BankApplication.User;
//
//import com.prafful.bank.BankApplication.Exceptions.UserNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//
//
//public final class UserCustomRepositoryImpl implements UserCustomRepository {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public User updateUser(User user) throws UserNotFoundException {
//        Optional<User> existingUser = userRepository.findById(user.getId());
//
//        existingUser.orElseThrow(() -> new UserNotFoundException(user.getId()));
//
//        User existUser = existingUser.get();
//
//        existUser.setActive(user.getActive());
//        existUser.setPassword(user.getPassword());
//        existUser.setRole(user.getRole());
//
//        return userRepository.save(existUser);
//    }
//}
