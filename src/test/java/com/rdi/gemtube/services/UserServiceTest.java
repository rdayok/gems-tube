package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.responses.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("dayokr@gmail.com");
        registerRequest.setPassword("wealthyman_");

        RegisterResponse registerResponse = userService.register(registerRequest);
        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getId());
    }

}
