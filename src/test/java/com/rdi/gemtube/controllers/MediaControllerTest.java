package com.rdi.gemtube.controllers;

import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockPart;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import static com.rdi.gemtube.services.CloudServiceTest.IMAGE_LOCATION;
import static com.rdi.gemtube.services.MediaServiceTest.getTestFile;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

@SpringBootTest
@AutoConfigureMockMvc
public class MediaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUploadMedia() {
        UploadMediaRequest uploadMediaRequest = new UploadMediaRequest();
        MultipartFile file = getTestFile(IMAGE_LOCATION);
        uploadMediaRequest.setTitle("Passport");
        uploadMediaRequest.setDescription("My most recent passport snapped by Snappy");
        uploadMediaRequest.setCreatorId(100L);
        uploadMediaRequest.setMultipartFile(file);

        mockMvc.perform(multipart("/api/vi/media")
                .part(new MockPart("media", file.getBytes())));
    }
}
