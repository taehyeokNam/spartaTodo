package org.example.spartaschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.manager.ManagerDetailResponseDto;
import org.example.spartaschedule.dto.manager.ManagerSaveRequestDto;
import org.example.spartaschedule.dto.manager.ManagerSaveResponseDto;
import org.example.spartaschedule.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/todos/{todoId}/managers")
    public ResponseEntity<ManagerSaveResponseDto> saveUserTodo (@PathVariable Long todoId, @RequestBody ManagerSaveRequestDto managerSaveRequestDto) {
        return ResponseEntity.ok(managerService.saveManager(todoId, managerSaveRequestDto));
    }

    @GetMapping("/tods/{todoId}/managers")
    public ResponseEntity<List<ManagerDetailResponseDto>> getMembers(@PathVariable Long todoId) {
        return ResponseEntity.ok(managerService.getMembers(todoId));
    }
}
