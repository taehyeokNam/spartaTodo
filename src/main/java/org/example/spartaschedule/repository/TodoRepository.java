package org.example.spartaschedule.repository;

import org.example.spartaschedule.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
