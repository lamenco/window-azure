package com.example.demo.models.entity;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String fullName;
    private String email;
    private String password;

    private List<UserRole> userRole = new ArrayList<>();

    public User() {
    }

    public User(String username, String fullName, String email, String password, List<UserRole> userRole) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<UserRole> getUserRole() {
        return userRole;
    }

    public User setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
        return this;
    }
}
