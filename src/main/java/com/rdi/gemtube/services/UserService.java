package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.User;
import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.responses.RegisterResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import org.springframework.stereotype.Service;


public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);

    User getUserById(Long creatorId) throws GemTubeException;
}
