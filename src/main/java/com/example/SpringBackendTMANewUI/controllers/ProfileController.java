package com.example.SpringBackendTMANewUI.controllers;

import com.example.SpringBackendTMANewUI.models.*;
import com.example.SpringBackendTMANewUI.services.impl.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService profileService;
    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @GetMapping
    public List<Profile> getAllProfiles() throws JpaSystemException {
        return profileService.getAllProfiles();
    }
    @PostMapping
    public Profile saveProfile(@RequestBody Profile profile) throws JpaSystemException{
        return profileService.saveProfile(profile);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Profile> getProfileByEmail(@PathVariable String email) {
        try {
            Profile profile = profileService.findProfileByEmail(email);
            if (profile != null) {
                return ResponseEntity.ok(profile);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (JpaSystemException e) {
            // Handle the JpaSystemException as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<Profile> getProfileByPhoneNumber(@PathVariable String phoneNumber) throws JpaSystemException {
        Profile profile = profileService.findProfileByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(profile);
    }
    @GetMapping("/maxId")
    public ResponseEntity<Profile> getProfileByMaxId() throws JpaSystemException {
        try {
            Profile profile = profileService.findProfileWithIdMax();
            if (profile != null) {
                return ResponseEntity.ok(profile);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (JpaSystemException e) {
            // Handle the JpaSystemException as appropriate
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/email/{email}")
    public ResponseEntity<Void> updateProfileByEmail(@PathVariable String email, @RequestBody Profile profile) {
        try {
            Profile foundProfile = profileService.findProfileByEmail(email);
            if (foundProfile != null) {
                profileService.updateProfileByEmail(email,profile);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (JpaSystemException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
