package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.comment.*;
import org.example.spartaschedule.dto.user.UserDto;
import org.example.spartaschedule.entity.Comment;
import org.example.spartaschedule.entity.Todo;
import org.example.spartaschedule.entity.User;
import org.example.spartaschedule.repository.CommentRepository;
import org.example.spartaschedule.repository.TodoRepository;
import org.example.spartaschedule.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {

        Todo todo = findTodoById(todoId);

        User user = findUserById(commentSaveRequestDto.getId());

        Comment newComment = new Comment(user, commentSaveRequestDto.getComment(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getComment(),
                savedComment.getCreatedAt(),
                new UserDto(user.getId(), user.getUserName(), user.getEmail())
        );
    }

    public List<CommentSimpleResponseDto> getComments(Long todoId) {

        Todo todo = findTodoById(todoId);

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();

        for(Comment comment : todo.getComments()) {
            User user = comment.getUser();
            CommentSimpleResponseDto dto = new CommentSimpleResponseDto(
                    comment.getId(),
                    new UserDto(user.getId(), user.getUserName(), user.getEmail()),
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

        User user = comment.getUser();

        return new CommentDetailResponseDto(
                comment.getId(),
                new UserDto(user.getId(), user.getUserName(), user.getEmail()),
                comment.getComment(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
                );
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {

        Comment comment = findCommentById(commentId);
        comment.update(commentUpdateRequestDto.getComment());

        return new CommentUpdateResponseDto(
                comment.getId(),
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

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다."));
    }

}
