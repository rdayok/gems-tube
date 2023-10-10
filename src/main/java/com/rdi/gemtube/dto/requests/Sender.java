package com.rdi.gemtube.dto.requests;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
public class Sender {
    private final String email;
    private final String name;
}
