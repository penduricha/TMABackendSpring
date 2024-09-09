package com.example.SpringBackendTMANewUI.services.impl;

import com.example.SpringBackendTMANewUI.models.Profile;
import com.example.SpringBackendTMANewUI.repositories.ProfileRepository;
import com.example.SpringBackendTMANewUI.services.I_ProfileService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfileService implements I_ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile saveProfile(Profile profile) throws JpaSystemException {
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAllProfiles() throws JpaSystemException {
        return profileRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Profile findProfileByEmail(String email) throws JpaSystemException {
        return profileRepository.findByEmail(email);
    }

    @Override
    public Profile findProfileByPhoneNumber(String phoneNumber) throws JpaSystemException {
        return profileRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Profile findProfileWithIdMax()  throws JpaSystemException{
        return profileRepository.findTopByOrderByIdDesc();
    }

    @Override
    public void updateProfileByEmail(String email, Profile profile) throws JpaSystemException {
        Profile foundProfile=findProfileByEmail(email);
        if(foundProfile!=null){
            profileRepository.save(profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

}
