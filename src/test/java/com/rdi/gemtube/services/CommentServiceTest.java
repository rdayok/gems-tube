package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.CreateCommentRequest;

import com.rdi.gemtube.dto.requests.UpdateCommentRequest;
import com.rdi.gemtube.dto.responses.ApiResponse;

import com.rdi.gemtube.exceptions.GemTubeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql("/db/insert.sql")
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;


    @Test
    public void testAddComment() throws GemTubeException {
        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        createCommentRequest.setCommenterId(100L);
        createCommentRequest.setComment("I will blow up your head");
        var addCommentResponse = commentService.addComment(105L, createCommentRequest);
        assertThat(addCommentResponse).isNotNull();
        assertThat(addCommentResponse).isInstanceOf(ApiResponse.class);
    }

    @Test
    public void testUpdateComment() {
        UpdateCommentRequest updateCommentRequest = new UpdateCommentRequest();
        updateCommentRequest.setText("I feel your swag gee");
        ApiResponse<?> response = commentService.updateComment(200L, 105L, updateCommentRequest);
    }
}
