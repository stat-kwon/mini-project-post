package com.hh99.adassignment.controller;

import com.hh99.adassignment.dto.LoginUserDto;
import com.hh99.adassignment.dto.PersistUserDto;
import com.hh99.adassignment.dto.SignupRequestDto;
import com.hh99.adassignment.model.User;
import com.hh99.adassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/login")
    public String login(){
        return "login";
    }

    @GetMapping("user/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("user/signup")
    public String registerUser(SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
        return "redirect:/user/login";
    }

    // 415 Error 해결 못함..
    @PostMapping("user/login")
    public String loginUser(LoginUserDto loginUserDto) {
        User user = userService.loginUser(loginUserDto);
        PersistUserDto persistUserDto = new PersistUserDto(user.getId(), user.getName(), user.getEmail(),user.getPassword());
        return "redirect:/";
    }
}
