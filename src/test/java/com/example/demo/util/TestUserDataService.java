package com.example.demo.util;

import com.example.demo.models.entity.UserRole;
import com.example.demo.models.enums.UserRoleEnum;
import com.example.demo.models.user.WindowShopperUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TestUserDataService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new WindowShopperUserDetails(1L, "123","admin",
                "Admin",Collections.emptyList());
    }

}
