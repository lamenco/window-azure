package com.example.demo.service.impl;

import com.example.demo.models.entity.User;
import com.example.demo.models.entity.UserRole;
import com.example.demo.models.user.WindowShopperUserDetails;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


public class   WindowShopperUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public WindowShopperUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }

    private UserDetails map(User user) {
        return new WindowShopperUserDetails(user.getPassword(), user.getUsername(), user.getFullName()
                , user.getUserRole().stream().map(this::map).toList());
    }

    private GrantedAuthority map(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());

    }
}
