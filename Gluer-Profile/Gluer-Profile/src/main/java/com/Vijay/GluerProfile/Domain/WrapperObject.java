package com.Vijay.GluerProfile.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrapperObject {
    private ProfileEntity profileEntity;
    private User user;
}
