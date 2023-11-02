package com.rdi.gemtube.services;

import com.rdi.gemtube.exceptions.MediaUploadException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.rdi.gemtube.enums.Type.IMAGE;
import static com.rdi.gemtube.enums.Type.VIDEO;
import static com.rdi.gemtube.services.MediaServiceTest.getTestFile;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {

    @Autowired
    private CloudService cloudService;
    public static final String IMAGE_LOCATION = "C:\\Users\\WEALTHYMAN\\Documents\\REALCODE\\gemtube\\src\\main\\resources\\assets\\darda.jpg";
    public static final String VIDEO_LOCATION = "C:\\Users\\WEALTHYMAN\\Documents\\REALCODE\\gemtube\\src\\main\\resources\\assets\\The craziest 30-seconds of all time!.mp4";


    @Test
    public void testUpLoadFile() throws MediaUploadException {
        Path path = Paths.get(IMAGE_LOCATION);
        String uploadResponse;
        try (var inputStream = Files.newInputStream(path)) {
            MultipartFile file = new MockMultipartFile("darda-image", inputStream);
            uploadResponse = cloudService.upload(file);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

        assertNotNull(uploadResponse);
    }

    @Test
    public void testUploadVideo() throws MediaUploadException {
        String uploadResponse = cloudService.upload(getTestFile(VIDEO_LOCATION));
        assertNotNull(uploadResponse);
    }
}
