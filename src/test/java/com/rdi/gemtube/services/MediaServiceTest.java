package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MediaServiceTest {

    @Autowired
    private MediaService mediaService;
    @Autowired
    private UserService userService;

    @Test
    public void testMediaService() throws GemTubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("dayokr@gmail.com");
        registerRequest.setPassword("iam_zen");
        var registerResponse = userService.register(registerRequest);
        UploadMediaRequest uploadMediaRequest = new UploadMediaRequest();
        uploadMediaRequest.setCreatorId(registerResponse.getId());
        uploadMediaRequest.setDescription("A close up shot of my picture");
        uploadMediaRequest.setTitle("My passport");
        uploadMediaRequest.setMultipartFile(getTestFile());
        UploadMediaResponse response = mediaService.upload(uploadMediaRequest);
        assertThat(response).isNotNull();
    }

    public static MultipartFile getTestFile() {
        Path path = Paths.get("C:\\Users\\WEALTHYMAN\\Documents\\REALCODE\\gemtube\\src\\main\\resources\\assets\\darda.jpg");
        try (var inputStream = Files.newInputStream(path)) {
            return new MockMultipartFile("darda-image", inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}
