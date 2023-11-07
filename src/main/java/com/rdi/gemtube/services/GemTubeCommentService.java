package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.Comment;
import com.rdi.gemtube.data.models.Media;
import com.rdi.gemtube.data.models.User;
import com.rdi.gemtube.data.repositories.CommentRepository;
import com.rdi.gemtube.dto.requests.CreateCommentRequest;
import com.rdi.gemtube.dto.requests.UpdateCommentRequest;
import com.rdi.gemtube.dto.responses.ApiResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GemTubeCommentService implements CommentService{

    private final UserService userService;
    private final MediaService mediaService;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;



    @Override
    public ApiResponse<?> addComment(Long mediaId, CreateCommentRequest createCommentRequest) throws GemTubeException {
        Media foundMedia = mediaService.getMediaById(mediaId);
        Comment comment = modelMapper.map(createCommentRequest, Comment.class);
        comment.setMedia(foundMedia);
        comment.setCommenter(userService.getUserById(createCommentRequest.getCommenterId()));
        commentRepository.save(comment);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("comment added successfully");
        return response;
    }

    @Override
    public ApiResponse<?> updateComment(
            Long commentId, Long commenterId, UpdateCommentRequest updateCommentRequest
    ) throws GemTubeException {
        var comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Comment with id %d not found", commentId)));
        var originalCommenterId = comment.getCommenter().getId();
        if (!originalCommenterId.equals(commenterId))
            throw new GemTubeException("Only comment creator can update comment");
        comment.setComment(updateCommentRequest.getComment());
        commentRepository.save(comment);

        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Comment updated successfully");
        return response;
    }


    private Comment saveNewComment(CreateCommentRequest createCommentRequest, User commenter, Media mediaCommentedOn) {
        Comment comment = new Comment();
        comment.setComment(createCommentRequest.getComment());
        comment.setCommenter(commenter);
        comment.setMedia(mediaCommentedOn);
        return commentRepository.save(comment);
    }

}
