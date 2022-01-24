package com.Vijay.GluerProfile.Domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ProfileEntity {
    @Id
    @Column(name = "email",nullable = false)
    private String Email;
    private LocalDate DateOfBirth;
    private String Profession;
    private String Gender;
    private String Location;
    private String Address;
    private Long MobileNumber;


    public ProfileEntity() {
    }

    public ProfileEntity(String email, LocalDate dateOfBirth, String profession, String gender, String location, String address, Long mobileNumber) {
        Email = email;
        DateOfBirth = dateOfBirth;
        Profession = profession;
        Gender = gender;
        Location = location;
        Address = address;
        MobileNumber = mobileNumber;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        MobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "ProfileEntity{" +
                "Email='" + Email + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Profession='" + Profession + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Location='" + Location + '\'' +
                ", Address='" + Address + '\'' +
                ", MobileNumber=" + MobileNumber +
                '}';
    }
}
