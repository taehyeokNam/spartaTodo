package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.comment.*;
import org.example.spartaschedule.entity.Comment;
import org.example.spartaschedule.entity.Todo;
import org.example.spartaschedule.repository.CommentRepository;
import org.example.spartaschedule.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {

        Todo todo = findTodoById(todoId);

        Comment newComment = new Comment(commentSaveRequestDto.getUser(), commentSaveRequestDto.getComment(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getUser(),
                savedComment.getComment(),
                savedComment.getCreatedAt());
    }

    public List<CommentSimpleResponseDto> getComments(Long todoId) {

        Todo todo = findTodoById(todoId);

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();

        for(Comment comment : todo.getComments()) {
            CommentSimpleResponseDto dto = new CommentSimpleResponseDto(
                    comment.getId(),
                    comment.getUser(),
                    comment.getComment(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt()
            );

            dtoList.add(dto);
        }
        return dtoList;
    }

    public CommentDetailResponseDto getComment(Long commentId) {

        Comment comment = findCommentById(commentId);

        return new CommentDetailResponseDto(
                comment.getId(),
                comment.getUser(),
                comment.getComment(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
                );
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {

        Comment comment = findCommentById(commentId);
        comment.update(commentUpdateRequestDto.getUser(), commentUpdateRequestDto.getComment());


        return new CommentUpdateResponseDto(
                comment.getId(),
                comment.getUser(),
                comment.getComment(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }

    @Transactional
    public void deleteComment(Long commentId) {
        if(findCommentById(commentId) != null)
            commentRepository.deleteById(commentId);
    }

    private Todo findTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));
    }

    private Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("존재하지 않는 댓글입니다."));
    }



}
