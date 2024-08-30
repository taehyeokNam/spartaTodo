package org.example.spartaschedule.domain.comment.repository;

import org.example.spartaschedule.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
