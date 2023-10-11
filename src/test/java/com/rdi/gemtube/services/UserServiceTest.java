package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.User;
import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.responses.RegisterResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    private RegisterResponse registerResponse;


    @BeforeEach
    public void setUp() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("dayokr@gmail.com");
        registerRequest.setPassword("wealthyman_");
        registerResponse = userService.register(registerRequest);
    }

    @Test
    public void testRegisterUser() {
        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getId());
    }

    @Test
    public void testGetUserById() throws GemTubeException {
        User user = userService.getUserById(registerResponse.getId());
        assertThat(user).isNotNull();
    }

}
