package com.rdi.gemtube.dto.requests;

import com.rdi.gemtube.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadMediaRequest {

    private Long creatorId;
    private String title;
    private MultipartFile multipartFile;
    private String Description;
}
