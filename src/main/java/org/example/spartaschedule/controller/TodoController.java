package org.example.spartaschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.todo.*;
import org.example.spartaschedule.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        return ResponseEntity.ok(todoService.saveTodo(todoSaveRequestDto));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoSimpleResponseDto>> getTodos() {
        return ResponseEntity.ok(todoService.getTodos());
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoDetailResponseDto> getTodo(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<TodoUpdateResponseDto> updateTodo(@PathVariable Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateRequestDto));
    }
}
