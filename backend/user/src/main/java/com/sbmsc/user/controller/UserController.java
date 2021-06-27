package com.sbmsc.user.controller;

import com.sbmsc.user.model.User;
import com.sbmsc.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // get all employees
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
