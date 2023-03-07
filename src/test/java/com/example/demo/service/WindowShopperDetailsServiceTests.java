package com.example.demo.service;

import com.example.demo.models.entity.User;
import com.example.demo.models.entity.UserRole;
import com.example.demo.models.enums.UserRoleEnum;
import com.example.demo.models.user.WindowShopperUserDetails;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.WindowShopperUserDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class WindowShopperDetailsServiceTests {
    @Mock
    private UserRepository mockUserRepo;
    private WindowShopperUserDetailsService test;

    @BeforeEach
    void setUp() {
        test = new WindowShopperUserDetailsService(mockUserRepo);
    }

    @Test
    void testLoadUserByUsername_UserExist() {
        //arrange
        User testUser = new User("pesho", "Pesho", "a@a", "123",
                List.of(new UserRole().setUserRole(UserRoleEnum.USER), new UserRole().setUserRole(UserRoleEnum.ADMIN)));

        when(mockUserRepo.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        //act
        WindowShopperUserDetails userDetails = (WindowShopperUserDetails)
                test.loadUserByUsername(testUser.getUsername());
        //assert
        Assertions.assertEquals(testUser.getUsername(),userDetails.getUsername());
        Assertions.assertEquals(testUser.getFullName(),userDetails.getFullName());
        Assertions.assertEquals(testUser.getPassword(),userDetails.getPassword());

        var authorities= userDetails.getAuthorities();

        Assertions.assertEquals(2,authorities.size());

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals("ROLE_"+ UserRoleEnum.USER.name(),authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_"+ UserRoleEnum.ADMIN.name(),authoritiesIter.next().getAuthority());
    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                ()->test.loadUserByUsername("not-exist"));

    }
}

