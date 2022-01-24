package com.Vijay.GluerProfile.Repository;

import com.Vijay.GluerProfile.Domain.ProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends CrudRepository<ProfileEntity,String> {
}
