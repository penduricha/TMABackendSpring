package com.example.SpringBackendTMANewUI.services.impl;

import com.example.SpringBackendTMANewUI.models.User;
import com.example.SpringBackendTMANewUI.repositories.UserRepository;
import com.example.SpringBackendTMANewUI.services.I_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements I_UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws JpaSystemException {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() throws JpaSystemException{
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id","email"));
    }
}
