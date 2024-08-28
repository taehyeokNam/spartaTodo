package org.example.spartaschedule.repository;

import org.example.spartaschedule.entity.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTodoRepository extends JpaRepository<UserTodo, Long> {
}
