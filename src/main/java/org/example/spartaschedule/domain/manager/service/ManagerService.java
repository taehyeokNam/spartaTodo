package org.example.spartaschedule.domain.manager.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.domain.manager.dto.ManagerDetailResponseDto;
import org.example.spartaschedule.domain.manager.dto.ManagerSaveRequestDto;
import org.example.spartaschedule.domain.manager.dto.ManagerSaveResponseDto;
import org.example.spartaschedule.domain.user.dto.UserDto;
import org.example.spartaschedule.domain.todo.entity.Todo;
import org.example.spartaschedule.domain.user.entity.User;
import org.example.spartaschedule.domain.manager.entity.Manager;
import org.example.spartaschedule.domain.todo.repository.TodoRepository;
import org.example.spartaschedule.domain.user.repository.UserRepository;
import org.example.spartaschedule.domain.manager.repository.ManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public ManagerSaveResponseDto saveManager(Long todoId, ManagerSaveRequestDto managerSaveRequestDto) {

        Todo todo =findTodoById(todoId);

        User user = findUserById(managerSaveRequestDto.getTodoUserId());

        if(!(todo.getUser() != null &&
                ObjectUtils.nullSafeEquals(user.getId(), todo.getUser().getId()))) {
            throw new NullPointerException("담당자를 등록하려고 하는 유저가 일정을 만든 유저가 아닙니다.");
        }

        User manager = findUserById(managerSaveRequestDto.getManagerUserId());

        Manager newManager = new Manager(todo, manager);
        Manager savedManager = managerRepository.save(newManager);

        return new ManagerSaveResponseDto(savedManager.getId());

    }

    public List<ManagerDetailResponseDto> getMembers(Long todoId) {
        Todo todo = findTodoById(todoId);

        List<Manager> managerList = managerRepository.findByTodoId(todo.getId());
        List<ManagerDetailResponseDto> dtoList = new ArrayList<>();

        for (Manager manager : managerList) {
            User user = manager.getUser();
            dtoList.add(new ManagerDetailResponseDto(
                    manager.getId(),
                    new UserDto(user.getId(), user.getUserName(), user.getEmail())
           ));
        }
        return dtoList;
    }

    private Todo findTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));
    }
}
