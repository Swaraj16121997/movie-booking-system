package com.example.showbookingsystem.services;

import com.example.showbookingsystem.models.User;
import com.example.showbookingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User signUp(String username, String email, String password){
        User user = new User();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setEmailId(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUsername(username);
        user.setTicketBookings(new ArrayList<>());

        return userRepository.save(user);
    }

    public User login(String username, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmailId(email);
        if (optionalUser.isEmpty()) {
            System.out.println("You don't have an account. Hence, signing you up with the details you entered");
            signUp(username,email,password);
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = optionalUser.get();

        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            //Login successful
            return user;
        }
        throw new RuntimeException("Incorrect password. Please retry!!");
    }
}
