package com.Vijay.GluerProfile.Service;

import com.Vijay.GluerProfile.Domain.ProfileEntity;
import com.Vijay.GluerProfile.Domain.User;
import com.Vijay.GluerProfile.Domain.WrapperObject;
import com.Vijay.GluerProfile.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class ProfileServiceImpl implements ProfileService{


    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String saveProfile(ProfileEntity profileEntity) {
        profileRepo.save(profileEntity);
        String result="Profile Updated SuccessFully";
        return result;
    }

    @Override
    public ProfileEntity getProfile(String email) {
        ProfileEntity byId = profileRepo.findById(email).get();
        return byId;
    }


    @Override
    public String updateProfile(String email, ProfileEntity profileEntity) {
        ProfileEntity profileEntity1 = profileRepo.findById(email).get();
        profileEntity1.setMobileNumber(profileEntity.getMobileNumber());
        profileEntity1.setAddress(profileEntity.getAddress());
        profileEntity1.setProfession(profileEntity.getProfession());
        profileEntity1.setGender(profileEntity.getGender());
        profileEntity1.setLocation(profileEntity.getLocation());
        profileRepo.save(profileEntity1);
        return "Profile Updated Successfully";
    }

    @Override
    public WrapperObject getUserByProfile(String email) {
        ProfileEntity profileEntity=profileRepo.findById(email).get();
        WrapperObject wrapperObject=new WrapperObject();
        User user=restTemplate.getForObject("http://USER-SERVICE/gluser/user/"+profileEntity.getEmail(),User.class);
        wrapperObject.setUser(user);
        wrapperObject.setProfileEntity(profileEntity);
        return wrapperObject;
    }
}
