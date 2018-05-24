package com.andikasoft.rwandacattle.rwandacattle.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {
    int id;
    String name;
    String email;
    String phone_number;
    String profile_image;
    String confirmed;
    String confirmation_code;
    String created_at;
    String updated_at;
    ArrayList<Role> roles;

    // constructors

    public User() {
    }

    public User(int id, String name, String email, String phone_number, String profile_image, String confirmed, String confirmation_code, String created_at, String updated_at, ArrayList<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.profile_image = profile_image;
        this.confirmed = confirmed;
        this.confirmation_code = confirmation_code;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getConfirmation_code() {
        return confirmation_code;
    }

    public void setConfirmation_code(String confirmation_code) {
        this.confirmation_code = confirmation_code;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }
}
