package com.example.demo.models.entity;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String username;
    private String fullName;
    private String email;
    private String password;

    private List<UserRole> userRole = new ArrayList<>();

    public User() {
    }
    @Column(nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Column(nullable = false,unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }
}
