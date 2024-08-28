package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.comment.CommentSaveRequestDto;
import org.example.spartaschedule.dto.comment.CommentSaveResponseDto;
import org.example.spartaschedule.entity.Comment;
import org.example.spartaschedule.entity.Todo;
import org.example.spartaschedule.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long commentId, CommentSaveRequestDto commentSaveRequestDto) {
        Comment newComment = new Comment(commentSaveRequestDto.getUser(), commentSaveRequestDto.getComment());

        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getUser(),
                savedComment.getComment(),
                savedComment.getCreatedAt());
    }





    private Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));
    }
}
