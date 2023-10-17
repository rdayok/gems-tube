package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.CreateCommentRequest;
import com.rdi.gemtube.dto.responses.CreateCommentResponse;
import com.rdi.gemtube.exceptions.GemTubeException;

public interface CommentService {
    CreateCommentResponse createComment(CreateCommentRequest createCommentRequest) throws GemTubeException;
}
