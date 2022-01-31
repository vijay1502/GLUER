package com.Vijay.GluerProfile.Controller;

import com.Vijay.GluerProfile.Domain.ProfileEntity;
import com.Vijay.GluerProfile.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glueProfile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("/post")
    public String postProfile(@RequestBody ProfileEntity profileEntity){
        String Output = profileService.saveProfile(profileEntity);
        return Output;
    }

    @GetMapping("/profile/{email}")
    public List<ProfileEntity> searchByName(@PathVariable String email){
        List<ProfileEntity> profile = profileService.getProfile(email);
        return profile;
    }


    @PutMapping("/profile/update/{email}")
    public String profileUpdater(@PathVariable String email,@RequestBody ProfileEntity profileEntity){
        String Output = profileService.updateProfile(email, profileEntity);
        return Output;
    }

    @GetMapping("/search/profes/{profession}")
    public List<ProfileEntity> searchByProfession(@PathVariable String profession){
        List<ProfileEntity> professionDetails = profileService.getProfession(profession);
        return professionDetails;
    }

}
