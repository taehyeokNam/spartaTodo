package org.example.spartaschedule.dto.todo;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {

    private String title;
    private Long userId;
    private String description;
}
