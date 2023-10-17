package com.rdi.gemtube.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentResponse {
    private Long commentId;
    private Long commentedMediaId;
    private String message;

}
