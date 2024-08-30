package org.example.spartaschedule.domain.todo.dto;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {

    private String title;
    private Long userId;
    private String description;
}
