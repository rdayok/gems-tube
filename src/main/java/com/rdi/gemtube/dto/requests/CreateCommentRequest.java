package com.rdi.gemtube.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCommentRequest {
    private Long commenterId;
    private Long MediaId;
    private String message;
}
