package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.entity.Todo;
import org.example.spartaschedule.entity.User;
import org.example.spartaschedule.entity.UserTodo;
import org.example.spartaschedule.repository.TodoRepository;
import org.example.spartaschedule.repository.UserRepository;
import org.example.spartaschedule.repository.UserTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserTodoService {

    private final UserTodoRepository userTodoRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;


    @Transactional
    public void saveUSerTodo(Long todoId, Long userId) {
        Todo todo = findTodoById(todoId);
        User user = findUserById(userId);

        UserTodo userTodo = new UserTodo(todo, user);
        userTodoRepository.save(userTodo);
    }


    private Todo findTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));
    }
}
