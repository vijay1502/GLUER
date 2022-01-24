package com.Vijay.GluerProfile.Service;

import com.Vijay.GluerProfile.Domain.ProfileEntity;
import com.Vijay.GluerProfile.Domain.WrapperObject;

import java.util.List;

public interface ProfileService {
    public String saveProfile(ProfileEntity profileEntity);
    public ProfileEntity getProfile(String email);
    public String updateProfile(String email, ProfileEntity profileEntity);
    public WrapperObject getUserByProfile(String email);
}
