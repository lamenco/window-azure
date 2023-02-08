package com.example.demo.service.impl;

import com.example.demo.models.entity.UserRole;
import com.example.demo.models.enums.UserRoleEnum;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void init() {
        if(userRoleRepository.count()==0){
            Arrays.stream(UserRoleEnum.values()).forEach(userRoleEnum -> {
                UserRole userRole = new UserRole();
                userRole.setUserRole(userRoleEnum);
                userRoleRepository.save(userRole);
            });
        }

    }
}
