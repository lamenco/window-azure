package com.example.demo.web;

import com.example.demo.models.entity.*;
import com.example.demo.models.enums.ChamberEnum;
import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.ModelEnum;
import com.example.demo.models.enums.UserRoleEnum;
import com.example.demo.util.TestDataUtils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OfferControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestDataUtils testDataUtils;
    private User testUser, testUser2;
    private Window testOffer ;

    @BeforeEach
    void setUp() {
//        testUser = new User("admin", "Admin", "a@a", "123",
//                List.of(new UserRole().setUserRole(UserRoleEnum.USER),
//                        new UserRole().setUserRole(UserRoleEnum.ADMIN)));
        testUser2= testDataUtils.createTestUser("pesho");
        testOffer = testDataUtils.createTestOffer(testUser2);



    }

    @AfterEach
    void tearDown() {
        testDataUtils.cleanUpDatabase();
    }


    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/cart/deleteWindow/1", testOffer.getId())
                        .with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    @WithMockUser(
            username = "pesho",
            roles =  "USER"
    )
    void testLoginDelete() throws Exception {

        mockMvc.perform(delete("/cart/deleteWindow/{id}", testOffer.getId())
                        .with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/cart"));
    }



}
