package com.example.SpringBackendTMANewUI.repositories;

import com.example.SpringBackendTMANewUI.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    public Profile findByEmail(String email);
    public Profile findByPhoneNumber(String phoneNumber);
    public Profile findTopByOrderByIdDesc();
}
