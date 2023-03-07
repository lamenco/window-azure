package com.example.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerIT2 {
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithUserDetails(value = "admin",
            userDetailsServiceBeanName = "testUserDataService")
    void testAddWindow() throws Exception {
        mockMvc.perform(post("/offer/window/add")
                        .param("height", "100").
                        param("width", "100").
                        param("model", "VIVAPLAST").
                        param("chamber", "FIVE_CHAMBER").
                        param("color", "WHITE")
                        .with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/"));

    }

    @Test
    @WithUserDetails(value = "admin",
            userDetailsServiceBeanName = "testUserDataService")
    void testAddDoor() throws Exception {
        mockMvc.perform(post("/offer/door/add")
                        .param("height", "100").
                        param("width", "100").
                        param("model", "VIVAPLAST").
                        param("material", "PVC").
                        param("chamber", "FIVE_CHAMBER").
                        param("color", "OAK")

                        .with(csrf())).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/"));

    }

}
