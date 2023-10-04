package com.rdi.gemtube.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {

    private String email;
    private String password;
}
