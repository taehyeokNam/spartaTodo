package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.todo.*;
import org.example.spartaschedule.entity.Todo;
import org.example.spartaschedule.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
                todoSaveRequestDto.getUser()
        );

        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getUser(),
                savedTodo.getDescription(),
                savedTodo.getCreatedAt()
        );
    }

    public Page<TodoSimpleResponseDto> getTodos(int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoSimpleResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getUser(),
                todo.getDescription(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        ));
//        List<Todo> todoList =  todoRepository.findAll();
//        List<TodoSimpleResponseDto> dtoList = new ArrayList<>();
//
//        for (Todo todo : todoList) {
//            TodoSimpleResponseDto dto = new TodoSimpleResponseDto(
//                    todo.getId(),
//                    todo.getTitle(),
//                    todo.getUser(),
//                    todo.getDescription(),
//                    todo.getCreatedAt(),
//                    todo.getModifiedAt()
//            );
//        }
//        return dtoList;
    }

    public TodoDetailResponseDto getTodo(Long todoId) {

        Todo todo = findTodoById(todoId);

        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getUser(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId , TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = findTodoById(todoId);

        todo.update(
                todoUpdateRequestDto.getTitle(),
                todoUpdateRequestDto.getUser(),
                todoUpdateRequestDto.getDescription()
        );

        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getUser(),
                todo.getDescription()
        );
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        if(!todoRepository.existsById(todoId)) {
            throw new NullPointerException("존재하지 않는 일정입니다.");
        }

        todoRepository.deleteById(todoId);
    }

    private Todo findTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));
    }

}
