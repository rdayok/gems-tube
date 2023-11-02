package com.rdi.gemtube.controllers;

import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.responses.RegisterResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse response = userService.register(registerRequest);
        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            var response = userService.getUserById(id);
            return ResponseEntity.ok(response);
        } catch (GemTubeException exception) {
            return ResponseEntity.badRequest().body(exception);
        }
    }
}

