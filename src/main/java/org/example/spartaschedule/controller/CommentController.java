package org.example.spartaschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.comment.*;
import org.example.spartaschedule.repository.CommentRepository;
import org.example.spartaschedule.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable Long todoId, CommentSaveRequestDto commentSaveRequestDto) {
        return ResponseEntity.ok(commentService.saveComment(todoId, commentSaveRequestDto));
    }

    @GetMapping("/todos/{todoId}/comments")
    public ResponseEntity<List<CommentSimpleResponseDto>> getComments(@PathVariable Long todoId) {
        return ResponseEntity.ok(commentService.getComments(todoId));
    }

    @GetMapping("/todos/comment/{commentId}")
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @PutMapping("/todos/comment/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(@PathVariable Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentUpdateRequestDto));
    }
}
