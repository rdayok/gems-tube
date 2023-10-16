package com.rdi.gemtube.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadMediaResponse {
    private String message;
    private Long mediaId;
}
