package com.Vijay.GluerProfile.Repository;

import com.Vijay.GluerProfile.Domain.ProfilePhoto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends MongoRepository<ProfilePhoto,String> {
}
