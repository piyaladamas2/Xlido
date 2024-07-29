package com.crio.xlido.Entities;

public class User extends BaseEntity {

    private String name;
    private String email;

    public User(Long userId, User entity) {
        super(userId);
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
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
}
