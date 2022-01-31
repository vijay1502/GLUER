package com.Vijay.GluerProfile.Domain;

public class UserDetails {
    private String Email;
    private String Name;

    private String password;
    private String confirmpass;
    private String Country;
    private String Validated;
    private String encryptor;

    public UserDetails(String email, String name, String password, String confirmpass, String country, String validated, String encryptor) {
        Email = email;
        Name = name;
        this.password = password;
        this.confirmpass = confirmpass;
        Country = country;
        Validated = validated;
        this.encryptor = encryptor;
    }

    public UserDetails() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getValidated() {
        return Validated;
    }

    public void setValidated(String validated) {
        Validated = validated;
    }

    public String getEncryptor() {
        return encryptor;
    }

    public void setEncryptor(String encryptor) {
        this.encryptor = encryptor;
    }
}
