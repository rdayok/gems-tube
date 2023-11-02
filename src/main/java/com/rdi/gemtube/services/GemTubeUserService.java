package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.User;
import com.rdi.gemtube.data.repositories.UserRepository;
import com.rdi.gemtube.dto.requests.EmailRequest;
import com.rdi.gemtube.dto.requests.Recipient;
import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.responses.RegisterResponse;
import com.rdi.gemtube.dto.responses.UserResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GemTubeUserService implements UserService{

    private final UserRepository userRepository;
    private final MailService mailService;
    private final ModelMapper modelMapper;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
//        user.setId(registerRequest.getId());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        User savedUser = userRepository.save(user);
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setRecipients(List.of(new Recipient(savedUser.getEmail(), "Fred")));
        emailRequest.setHtmlContent("<p>Hi, welcome to gemstube.com Have fun around");
        emailRequest.setSubject("Welcome to gemtube streaming service");
        mailService.sendMail(emailRequest);
        return new RegisterResponse(savedUser.getId());
    }

    @Override
    public User getUserById(Long creatorId) throws GemTubeException {
        return userRepository.findById(creatorId).orElseThrow(
                () -> new GemTubeException(String.format("user with %d not found", creatorId))
        );
    }

    @Override
    public UserResponse getUser(Long userId) {
        return null;
    }

}
