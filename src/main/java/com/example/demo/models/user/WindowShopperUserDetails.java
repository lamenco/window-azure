package com.example.demo.models.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class WindowShopperUserDetails implements UserDetails {

    private final String password;
    private final String username;
    private final String fullName;
    private final Collection<GrantedAuthority> authorities;

    public WindowShopperUserDetails(String password, String username, String fullName
    , Collection<GrantedAuthority> authorities) {
        this.password = password;
        this.username = username;
        this.fullName = fullName;
        this.authorities = authorities;
    }

    public String getFullName(){
        return  fullName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
