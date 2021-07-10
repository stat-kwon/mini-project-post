package com.hh99.adassignment.service;

import com.hh99.adassignment.dto.LoginUserDto;
import com.hh99.adassignment.dto.SignupRequestDto;
import com.hh99.adassignment.model.User;
import com.hh99.adassignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(SignupRequestDto signupRequestDto) {
        String name = signupRequestDto.getName();
        String password = signupRequestDto.getPassword();
        String email = signupRequestDto.getEmail();

        User user = new User(name, password, email);
        userRepository.save(user);
        return user;
    }

    public User loginUser(LoginUserDto loginUserDto) {
        String name = loginUserDto.getName();

        User user = userRepository.findByName(name).orElse(null);

        return user;
    }
}
