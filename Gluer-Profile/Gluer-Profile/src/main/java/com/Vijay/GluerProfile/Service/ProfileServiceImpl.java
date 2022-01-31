package com.Vijay.GluerProfile.Service;

import com.Vijay.GluerProfile.Domain.ProfileEntity;
import com.Vijay.GluerProfile.Domain.UserDetails;
import com.Vijay.GluerProfile.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{


    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String saveProfile(ProfileEntity profileEntity) {
        UserDetails userDetails=restTemplate.getForObject("http://localhost:8071/gluser/user/"+profileEntity.getEmail(),UserDetails.class);
        profileEntity.setName(userDetails.getName());
        profileRepo.save(profileEntity);

        String result="Profile Updated SuccessFully";
        return result;
    }

    @Override
    public List<ProfileEntity> getProfile(String email) {
        List<ProfileEntity> byId = profileRepo.getProfileEntityByEmailorName(email);
        return byId;
    }


    @Override
    public String updateProfile(String email, ProfileEntity profileEntity) {
        ProfileEntity profileEntity1 = profileRepo.getProfileEntityByEmail(email);
        profileEntity1.setMobileNumber(profileEntity.getMobileNumber());
        profileEntity1.setAddress(profileEntity.getAddress());
        profileEntity1.setProfession(profileEntity.getProfession());
        profileEntity1.setGender(profileEntity.getGender());
        profileEntity1.setLocation(profileEntity.getLocation());
        profileRepo.save(profileEntity1);
        return "Profile Updated Successfully";
    }

    @Override
    public List<ProfileEntity> getProfession(String Profession) {
        List<ProfileEntity> allProfileEntityByProfession = profileRepo.getProfileEntityByProfession(Profession);
        return allProfileEntityByProfession;
    }



}
