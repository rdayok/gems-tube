package com.rdi.gemtube.dto.requests;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Recipient {
    private String email;
    private String name;
}
