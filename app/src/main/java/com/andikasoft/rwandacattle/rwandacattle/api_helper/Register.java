package com.andikasoft.rwandacattle.rwandacattle.api_helper;

public class Register {

    String name;
    String email;
    String phone_number;
    String password;
    String password_confirmation;

    public Register(String name, String email, String phone_number, String password, String password_confirmation) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.password_confirmation = password_confirmation;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
}
