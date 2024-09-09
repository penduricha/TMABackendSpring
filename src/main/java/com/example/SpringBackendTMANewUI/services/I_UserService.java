package com.example.SpringBackendTMANewUI.services;

import com.example.SpringBackendTMANewUI.models.User;

import java.util.List;

public interface I_UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
}
