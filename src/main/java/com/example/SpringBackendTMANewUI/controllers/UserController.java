package com.example.SpringBackendTMANewUI.controllers;

import com.example.SpringBackendTMANewUI.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;
import com.example.SpringBackendTMANewUI.models.User;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() throws JpaSystemException {
        return userService.getAllUsers();
    }
    //phuong thuc POST
    @PostMapping
    public User createUser(@RequestBody User user) throws JpaSystemException{
        return userService.saveUser(user);
        //return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
}
