package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.Media;
import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.exceptions.MediaNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.rdi.gemtube.services.CloudServiceTest.IMAGE_LOCATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MediaServiceTest {

    @Autowired
    private MediaService mediaService;
    @Autowired
    private UserService userService;
    private UploadMediaResponse uploadMediaResponse;

    @BeforeEach
    public void setUp() throws GemTubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("dayokr@gmail.com");
        registerRequest.setPassword("iam_zen");
        var registerResponse = userService.register(registerRequest);
        UploadMediaRequest uploadMediaRequest = new UploadMediaRequest();
        uploadMediaRequest.setCreatorId(registerResponse.getId());
        uploadMediaRequest.setDescription("A close up shot of my picture");
        uploadMediaRequest.setTitle("My passport");
        uploadMediaRequest.setMultipartFile(getTestFile(IMAGE_LOCATION));
        uploadMediaResponse = mediaService.upload(uploadMediaRequest);

    }

    @Test
    public void testMediaService()  {
        assertThat(uploadMediaResponse).isNotNull();
    }

    @Test
    public void testGetMediaById() throws MediaNotFoundException {
        Media foundMedia = mediaService.getMediaById(uploadMediaResponse.getMediaId());
        assertNotNull(foundMedia);
    }

    public static MultipartFile getTestFile(String fileLocation) {
        Path path = Paths.get(fileLocation);
        try (var inputStream = Files.newInputStream(path)) {
            return new MockMultipartFile("darda-image", inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}
