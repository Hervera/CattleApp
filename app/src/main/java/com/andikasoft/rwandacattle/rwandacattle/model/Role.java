package com.andikasoft.rwandacattle.rwandacattle.model;

class Role {
    int id;
    String name;
    String display_name;
    String description;
    String created_at;
    String updated_at;
    RoleUser roleUser;

    public Role(int id, String name, String display_name, String description, String created_at, String updated_at, RoleUser roleUser) {
        this.id = id;
        this.name = name;
        this.display_name = display_name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.roleUser = roleUser;
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

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }
}
