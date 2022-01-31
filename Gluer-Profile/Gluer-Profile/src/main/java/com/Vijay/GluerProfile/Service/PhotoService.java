package com.Vijay.GluerProfile.Service;


import com.Vijay.GluerProfile.Domain.ProfilePhoto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    public String addPhoto(String title, MultipartFile file) throws IOException;
    public ProfilePhoto getPhoto(String id);
    public String updatePhoto(String email);
}
