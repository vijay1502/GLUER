package com.Vijay.GluerProfile.Service;

import com.Vijay.GluerProfile.Domain.ProfileEntity;

import java.util.List;

public interface ProfileService {
    public String saveProfile(ProfileEntity profileEntity);
    public List<ProfileEntity> getProfile(String email);
    public String updateProfile(String email, ProfileEntity profileEntity);
    public List<ProfileEntity> getProfession(String Profession);
}
