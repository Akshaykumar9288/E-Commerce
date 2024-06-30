package com.E_commerce.App.controller;

import com.E_commerce.App.Service.UserService;
import com.E_commerce.App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/Registration")
    public User Registration(@RequestBody User user){
        return userService.Registration(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody User user){
        User user1 = userService.login(user.getUsername(),user.getPassword());
        if (user1!=null){
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(400).body("Invalid username or password");
    }
}
