package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.responses.RegisterResponse;
import org.springframework.stereotype.Service;


public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);
}
