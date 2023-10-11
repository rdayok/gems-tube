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

import static com.rdi.gemtube.services.MediaServiceTest.getTestFile;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {

    @Autowired
    private CloudService cloudService;


    @Test
    public void testUpLoadFile() throws MediaUploadException {
        String uploadResponse = cloudService.upload(getTestFile());
        assertNotNull(uploadResponse);
//        Path path = Paths.get("C:\\Users\\WEALTHYMAN\\Documents\\REALCODE\\gemtube\\src\\main\\resources\\assets\\darda.jpg");
//        try (var inputStream = Files.newInputStream(path)) {
//            MultipartFile file = new MockMultipartFile("darda-image", inputStream);
//            String uploadResponse = cloudService.upload(file);
//            assertNotNull(uploadResponse);
//        } catch (IOException | MediaUploadException exception) {
//            exception.printStackTrace();
//            log.error("Error {}", exception.getMessage());
//            assertNotNull(exception);
//        }
    }
}
