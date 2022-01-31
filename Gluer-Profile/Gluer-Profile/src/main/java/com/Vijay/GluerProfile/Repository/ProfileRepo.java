package com.Vijay.GluerProfile.Repository;

import com.Vijay.GluerProfile.Domain.ProfileEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepo extends MongoRepository<ProfileEntity,String> {

    @Query("{Email:?0}")
    ProfileEntity getProfileEntityByEmail(String email);

    @Query("{'$or':[{Email:{$regex:?0,$options:'i'}},{'Name':{$regex:?0,$options:'i'}}]}")
    List<ProfileEntity> getProfileEntityByEmailorName(String search);

    @Query(value = "{Profession:{$regex:?0,$options:'i'}},$limit:5")
    List<ProfileEntity> getProfileEntityByProfession(String Profession);




}
