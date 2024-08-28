package org.example.spartaschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.repository.CommentRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
}
