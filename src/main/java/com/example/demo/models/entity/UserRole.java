package com.example.demo.models.entity;

import com.example.demo.models.enums.UserRoleEnum;
import javax.persistence.*;



@Entity
@Table(name = "user_roles")
public class UserRole extends BaseEntity{
    UserRoleEnum userRole;

    public UserRole() {

    }
    @Enumerated(EnumType.STRING)
    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }
}
