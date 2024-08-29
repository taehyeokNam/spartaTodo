package org.example.spartaschedule.dto.todo;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {

    private String title;
    private Long userId;
    private String description;
}
