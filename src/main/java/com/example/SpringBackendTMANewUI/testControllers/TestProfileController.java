package com.example.SpringBackendTMANewUI.testControllers;

import com.example.SpringBackendTMANewUI.models.Profile;
import com.example.SpringBackendTMANewUI.services.impl.ProfileService;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestProfileController{
    private final ProfileService profileService;

    public TestProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    /*
    private Long id;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String gender;
     */
    @RequestMapping("/postProfile")
    public String postData() throws JpaSystemException {
        Profile profile1=new Profile(1L,
                "ben10@edu.vn",
                "123Ben",
                "0981646633",
                "Nguyen Van Ben",
                "14 Ton Duc Thang",
                "Male",false);
        Profile profile2=new Profile(2L,
                "khang10@edu.vn",
                "123Khang",
                "0881646633",
                "Nguyen Van Khang",
                "14 Ton Duc Thang",
                "Male",false);
        Profile profile3=new Profile(3L,
                "minh10@edu.vn",
                "123Minh",
                "0281646633",
                "Nguyen Van Minh",
                "28 Ton Duc Thang",
                "Male",false);
        Profile profile4=new Profile(4L,
                "ben10@edu.vn",
                "123Ben",
                "0981646633",
                "Nguyen Van Ben",
                "14 Ton Duc Thang",
                "Male",false);
        Profile profile5=new Profile(5L,
                "kien10@edu.vn",
                "123Ken",
                "0971646633",
                "Nguyen Van Kien",
                "100 Ton Duc Thang",
                "Male",false);
        profileService.saveProfile(profile1);
        profileService.saveProfile(profile2);
        profileService.saveProfile(profile3);
        profileService.saveProfile(profile4);
        profileService.saveProfile(profile5);
        return "Insert successfully";
    }
}
