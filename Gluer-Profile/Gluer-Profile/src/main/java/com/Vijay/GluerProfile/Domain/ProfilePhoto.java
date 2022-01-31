package com.Vijay.GluerProfile.Domain;


import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "photos")
public class ProfilePhoto {
@Id
    private String email;
private String id;
private String title;
private Binary image;

    public ProfilePhoto() {
    }

    public ProfilePhoto(String title) {
        this.title = title;
    }

    public ProfilePhoto(String email, String id, String title, Binary image) {
        this.email = email;
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }
}
