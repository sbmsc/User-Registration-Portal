package com.sbmsc.user.controller;

import com.sbmsc.user.model.User;
import com.sbmsc.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // get all employees
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // CREATE USER
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
