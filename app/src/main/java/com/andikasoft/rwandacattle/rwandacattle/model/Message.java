package com.andikasoft.rwandacattle.rwandacattle.model;

public class Message {
    int id;
    int  user_id;
    String title;
    String message;
    String created_at;
    String updated_at;

    // constructors

    public Message() {
    }

    public Message(int id, int user_id, String title, String message, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.message = message;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // setter

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }


    // getter
    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
