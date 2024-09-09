package com.example.SpringBackendTMANewUI.repositories;

import com.example.SpringBackendTMANewUI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
