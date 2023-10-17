package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.CreateCommentRequest;
import com.rdi.gemtube.dto.requests.RegisterRequest;
import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.CreateCommentResponse;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.rdi.gemtube.services.CloudServiceTest.IMAGE_LOCATION;
import static com.rdi.gemtube.services.MediaServiceTest.getTestFile;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private MediaService mediaService;
    @Autowired
    private CommentService commentService;

    @Test
    public void testCreateComment() throws GemTubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("dayokr@gmail.com");
        registerRequest.setPassword("iam_zen");
        var registerResponse = userService.register(registerRequest);
        UploadMediaRequest uploadMediaRequest = new UploadMediaRequest();
        uploadMediaRequest.setCreatorId(registerResponse.getId());
        uploadMediaRequest.setDescription("A close up shot of my picture");
        uploadMediaRequest.setTitle("My passport");
        uploadMediaRequest.setMultipartFile(getTestFile(IMAGE_LOCATION));
        UploadMediaResponse uploadMediaResponse = mediaService.upload(uploadMediaRequest);

        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        createCommentRequest.setCommenterId(registerResponse.getId());
        createCommentRequest.setMediaId(uploadMediaResponse.getMediaId());
        createCommentRequest.setMessage("Hey this content is very good");

        CreateCommentResponse createCommentResponse = commentService.createComment(createCommentRequest);
        assertNotNull(createCommentResponse);
        assertNotNull(createCommentResponse.getCommentId());
    }
}
