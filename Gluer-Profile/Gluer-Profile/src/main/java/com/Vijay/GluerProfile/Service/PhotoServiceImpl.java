package com.Vijay.GluerProfile.Service;

import com.Vijay.GluerProfile.Domain.ProfilePhoto;
import com.Vijay.GluerProfile.Repository.PhotoRepo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    PhotoRepo photoRepo;

    @Override
    public String addPhoto(String title, MultipartFile file) throws IOException {
        ProfilePhoto photo=new ProfilePhoto();
        photo.setImage(new Binary(BsonBinarySubType.BINARY,file.getBytes()));
        photo=photoRepo.insert(photo);
        return photo.getId();
    }

    @Override
    public ProfilePhoto getPhoto(String id) {
        return photoRepo.findById(id).get();
    }

    @Override
    public String updatePhoto(String email) {
        return null;
    }
}