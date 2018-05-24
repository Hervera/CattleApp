package com.andikasoft.rwandacattle.rwandacattle.model;

public class Animal {
    int id;
    int  user_id;
    String category;
    String name;
    Boolean gender;
    int age;
    String weight;
    String size;
    String image;
    String created_at;
    String updated_at;

    // constructors

    public Animal() {
    }

    public Animal(int id, int user_id, String category, String name, Boolean gender, int age, String weight, String size, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.category = category;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.size = size;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    // getters
    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Boolean getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    public String getImage() {
        return image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
