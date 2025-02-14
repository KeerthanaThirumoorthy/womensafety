package com.project.womensafety.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.womensafety.entity.User;
import com.project.womensafety.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "User already exists!";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);  // Plain text password
        userRepository.save(user);
        return "User registered successfully!";
    }

    public boolean login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
