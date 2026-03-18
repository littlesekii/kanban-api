package com.littlesekii.kanban_api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MainController.class)
@ActiveProfiles("test")
public class MainControllerTest {
    
    private final MockMvc mockMvc;

    public MainControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void shouldReturnOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldReturnPongAndCorrectSchema() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ping"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Pong🏓"));
    }
}
