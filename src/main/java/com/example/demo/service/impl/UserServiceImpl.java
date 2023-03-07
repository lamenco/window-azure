package com.example.demo.service.impl;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.models.entity.User;
import com.example.demo.models.entity.UserRole;
import com.example.demo.models.enums.UserRoleEnum;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private final UserDetailsService userDetailsService;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, ModelMapper modelMapper1, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper1;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        User newUser = modelMapper.map(userRegisterDto, User.class);
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
//        List<UserRole> userRoles = new ArrayList<>();
//        UserRole userRole = new UserRole();
//        if(newUser.getUsername().equals("lambo")){
//           userRole.setUserRole(UserRoleEnum.ADMIN);
//           userRoles.add(userRole);
//        }else{
//            userRole.setUserRole(UserRoleEnum.USER);
//            userRoles.add(userRole);
//        }
//        newUser.setUserRole(userRoles);

        this.userRepository.save(newUser);
    }

    @Override
    public void login(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
