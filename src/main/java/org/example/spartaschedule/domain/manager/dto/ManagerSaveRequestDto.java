package org.example.spartaschedule.domain.manager.dto;

import lombok.Getter;

@Getter
public class ManagerSaveRequestDto {

    private Long todoId; //일정 작성자 유저 id
    private Long todoUserId; //일정 id
    private Long managerUserId; // 일정 작성가자 배치하는 유저 id

}
