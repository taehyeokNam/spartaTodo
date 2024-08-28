package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.TodoSaveRequestDto;
import org.example.spartaschedule.dto.TodoSaveResponseDto;
import org.example.spartaschedule.entity.Todo;
import org.example.spartaschedule.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo newTodo = new Todo(
                todoSaveRequestDto.getTitle(),
                todoSaveRequestDto.getDescription(),
                todoSaveRequestDto.getManagerName(),
                todoSaveRequestDto.getPassword()
        );

        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getManagerName(),
                savedTodo.getDescription(),
                savedTodo.getCreatedAt()
        );
    }

}
