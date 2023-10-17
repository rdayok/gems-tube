package com.rdi.gemtube.data.repositories;

import com.rdi.gemtube.data.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
