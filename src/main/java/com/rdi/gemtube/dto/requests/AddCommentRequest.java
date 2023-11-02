package com.rdi.gemtube.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCommentRequest {
    private Long commenterId;
    private String comment;
}
