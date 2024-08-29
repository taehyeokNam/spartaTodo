package org.example.spartaschedule.repository;

import org.example.spartaschedule.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    List<Manager> findByTodoId(Long id);
}
