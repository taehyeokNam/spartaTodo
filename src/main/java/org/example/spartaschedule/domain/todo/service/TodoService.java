package org.example.spartaschedule.domain.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.domain.todo.dto.*;
import org.example.spartaschedule.domain.user.dto.UserDto;
import org.example.spartaschedule.domain.todo.entity.Todo;
import org.example.spartaschedule.domain.user.entity.User;
import org.example.spartaschedule.domain.todo.repository.TodoRepository;
import org.example.spartaschedule.domain.user.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final TodoWeatherService todoWeatherService;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {

        User user = findUserById(todoSaveRequestDto.getUserId());

        String weather = todoWeatherService.getTodayWeather();

        Todo newTodo = new Todo(
                todoSaveRequestDto.getTitle(),
                user,
                todoSaveRequestDto.getDescription(),
                weather
        );

        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                new UserDto(user.getId(), user.getUserName(), user.getEmail()),
                savedTodo.getDescription(),
                savedTodo.getCreatedAt(),
                weather
        );
    }

    public Page<TodoSimpleResponseDto> getTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoSimpleResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getComments().size(),
                todo.getCreatedAt(),
                todo.getModifiedAt(),
                todo.getWeather()
            )
        );
    }

    public TodoDetailResponseDto getTodo(Long todoId) {

        Todo todo = findTodoById(todoId);
        User user = todo.getUser();

        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getTitle(),
                new UserDto(user.getId(), user.getUserName(), user.getEmail()),
                todo.getComments().size(),
                todo.getCreatedAt(),
                todo.getModifiedAt(),
                todo.getWeather()
        );
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId , TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = findTodoById(todoId);
        User user = todo.getUser();

        todo.update(
                todoUpdateRequestDto.getTitle(),
                todoUpdateRequestDto.getDescription()
        );

        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getTitle(),
                new UserDto(user.getId(), user.getUserName(), user.getEmail()),
                todo.getDescription(),
                todo.getWeather()
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

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));
    }

}
