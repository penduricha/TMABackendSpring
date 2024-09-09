package com.example.SpringBackendTMANewUI.services;
import com.example.SpringBackendTMANewUI.models.*;
import java.util.List;
public interface I_ProfileService {
    public Profile saveProfile(Profile profile);
    public List<Profile> getAllProfiles();
    public Profile findProfileByEmail(String email);
    public Profile findProfileByPhoneNumber(String phoneNumber);
    public Profile findProfileWithIdMax();
    public void updateProfileByEmail(String email,Profile profile);
}
