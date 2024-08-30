package org.example.spartaschedule.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.domain.comment.dto.*;
import org.example.spartaschedule.domain.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable Long todoId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return ResponseEntity.ok(commentService.saveComment(todoId, commentSaveRequestDto));
    }

    @GetMapping("/todos/{todoId}/comments")
    public ResponseEntity<List<CommentSimpleResponseDto>> getComments(@PathVariable Long todoId) {
        return ResponseEntity.ok(commentService.getComments(todoId));
    }

    @GetMapping("/todos/comments/{commentId}")
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @PutMapping("/todos/comments/{commentId}")
    public ResponseEntity<CommentDetailResponseDto> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {
        commentService.updateComment(commentId, commentUpdateRequestDto);
        return ResponseEntity.ok(commentService.getComment(commentId));

    }

    @DeleteMapping("todos/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
         commentService.deleteComment(commentId);
    }
}
