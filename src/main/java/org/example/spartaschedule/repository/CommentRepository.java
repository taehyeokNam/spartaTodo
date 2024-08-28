package org.example.spartaschedule.repository;

import org.example.spartaschedule.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
