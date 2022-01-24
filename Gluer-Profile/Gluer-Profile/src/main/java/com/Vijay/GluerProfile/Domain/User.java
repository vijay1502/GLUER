package com.Vijay.GluerProfile.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String Email;
    private String Name;

    private String password;
    private String confirmpass;
    private String Country;
    private String Validated;
    private String encryptor;
}
