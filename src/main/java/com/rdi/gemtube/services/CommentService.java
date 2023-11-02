package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.CreateCommentRequest;
import com.rdi.gemtube.dto.requests.UpdateCommentRequest;
import com.rdi.gemtube.dto.responses.ApiResponse;
import com.rdi.gemtube.dto.responses.CreateCommentResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.exceptions.MediaNotFoundException;

public interface CommentService {

    ApiResponse<?> addComment(Long mediaId, CreateCommentRequest createCommentRequest) throws GemTubeException;

    ApiResponse<?> updateComment(long mediaId, long commenterId, UpdateCommentRequest updateCommentRequest);
}
