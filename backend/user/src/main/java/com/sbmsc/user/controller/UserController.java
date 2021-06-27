package com.sbmsc.user.controller;

import com.sbmsc.user.exception.ResourceNotFoundException;
import com.sbmsc.user.model.User;
import com.sbmsc.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin()
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

    // CREATE USER
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // get user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("There is no user configured with the id: " + id));
        return ResponseEntity.ok(user);
    }

    //update user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User user = userRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("There is no user configured with the id: " + id));
        user.setEmailId(userDetails.getEmailId());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map <String, Boolean>>  deleteUser(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("There is no user configured with the id: " + id));
        userRepository.deleteById(id);
        Map <String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
