package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.Comment;
import com.rdi.gemtube.data.models.Media;
import com.rdi.gemtube.data.models.User;
import com.rdi.gemtube.data.repositories.CommentRepository;
import com.rdi.gemtube.dto.requests.CreateCommentRequest;
import com.rdi.gemtube.dto.responses.CreateCommentResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GemTubeCommentService implements CommentService{

    private final UserService userService;
    private final MediaService mediaService;
    private final CommentRepository commentRepository;

    @Override
    public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest) throws GemTubeException {
        User commenter = userService.getUserById(createCommentRequest.getCommenterId());
        Comment savedComment = buildComment(createCommentRequest, commenter);
        return buildCreateCommentResponse(createCommentRequest, savedComment);
    }

    private CreateCommentResponse buildCreateCommentResponse(CreateCommentRequest createCommentRequest, Comment savedComment) {
        Media savedMedia = buildMedia(createCommentRequest, savedComment);
        CreateCommentResponse createCommentResponse = new CreateCommentResponse();
        createCommentResponse.setMessage("Comment created successfully");
        createCommentResponse.setCommentId(savedComment.getId());
        createCommentResponse.setCommentedMediaId(savedMedia.getId());
        return createCommentResponse;
    }

    private Media buildMedia(CreateCommentRequest createCommentRequest, Comment savedComment) {
        Media media = mediaService.getMediaById(createCommentRequest.getMediaId());
        media.setComments(List.of(savedComment));
        return mediaService.save(media);
    }

    private Comment buildComment(CreateCommentRequest createCommentRequest, User commenter) {
        Comment comment = new Comment();
        comment.setCommenter(commenter);
        comment.setMessage(createCommentRequest.getMessage());
        return commentRepository.save(comment);
    }
}
