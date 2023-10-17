package com.rdi.gemtube.services;

import com.rdi.gemtube.exceptions.MediaUploadException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
        String uploadResponse = cloudService.upload(getTestFile(IMAGE_LOCATION));
        assertNotNull(uploadResponse);
    }

    @Test
    public void testUploadVideo() throws MediaUploadException {
        String uploadResponse = cloudService.upload(getTestFile(VIDEO_LOCATION));
        assertNotNull(uploadResponse);
    }
}
