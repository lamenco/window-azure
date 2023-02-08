package com.example.demo.service;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entity.User;

import java.util.Locale;

public interface UserService {

    void register(UserRegisterDto userRegisterDto);
    void login(String username);

    User findByUsername(String username);
}
