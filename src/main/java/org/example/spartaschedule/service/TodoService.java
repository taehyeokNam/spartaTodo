package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.*;
import org.example.spartaschedule.entity.Todo;
import org.example.spartaschedule.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public List<TodoSimpleResponseDto> getTodos() {

        List<Todo> todoList =  todoRepository.findAll();
        List<TodoSimpleResponseDto> dtoList = new ArrayList<>();

        for (Todo todo : todoList) {
            TodoSimpleResponseDto dto = new TodoSimpleResponseDto(
                    todo.getId(),
                    todo.getTitle(),
                    todo.getManagerName(),
                    todo.getDescription(),
                    todo.getCreatedAt(),
                    todo.getModifiedAt()
            );
        }
        return dtoList;
    }

    public TodoDetailResponseDto getTodo(Long todoId) {

        Todo todo = findTodoById(todoId);

        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getManagerName(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId , TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = findTodoById(todoId);

        todo.update(
                todoUpdateRequestDto.getTitle(),
                todoUpdateRequestDto.getManagerName(),
                todoUpdateRequestDto.getDescription()
        );

        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getManagerName(),
                todo.getDescription()
        );
    }


    private Todo findTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));
    }


}
