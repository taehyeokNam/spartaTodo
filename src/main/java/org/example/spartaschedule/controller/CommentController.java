package org.example.spartaschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.comment.CommentSaveRequestDto;
import org.example.spartaschedule.dto.comment.CommentSaveResponseDto;
import org.example.spartaschedule.repository.CommentRepository;
import org.example.spartaschedule.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable Long commentId, CommentSaveRequestDto commentSaveRequestDto) {
        return ResponseEntity.ok(commentService.saveComment(commentId, commentSaveRequestDto));
    }
}
