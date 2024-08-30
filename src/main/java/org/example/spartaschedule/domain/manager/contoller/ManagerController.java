package org.example.spartaschedule.domain.manager.contoller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.domain.manager.dto.ManagerDetailResponseDto;
import org.example.spartaschedule.domain.manager.dto.ManagerSaveRequestDto;
import org.example.spartaschedule.domain.manager.dto.ManagerSaveResponseDto;
import org.example.spartaschedule.domain.manager.service.ManagerService;
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
