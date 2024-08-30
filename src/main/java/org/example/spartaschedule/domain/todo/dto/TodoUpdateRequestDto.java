package org.example.spartaschedule.domain.todo.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {

    private String title;
    private Long userId;
    private String description;
}
