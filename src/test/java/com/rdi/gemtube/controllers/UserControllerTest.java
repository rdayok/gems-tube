package com.rdi.gemtube.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdi.gemtube.dto.requests.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegister() {
        ObjectMapper mapper = new ObjectMapper();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("gipati5703@qianhost.com");
        registerRequest.setPassword("password");
        try {
            byte[] json = mapper.writeValueAsBytes(registerRequest);
            mockMvc.perform(post("/api/v1/user")
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    @Sql("/db/insert.sql")
    public void testGetUserById() {
        try {
            mockMvc.perform(get("/api/v1/user/100"))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
