package org.example.spartaschedule.dto.todo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {

    private final Long id;
    private final String title;
    private final String user;
    private final String description;
    private final LocalDateTime createdAt;

    public TodoSaveResponseDto(
            Long id,
            String title,
            String user,
            String description,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.description = description;
        this.createdAt = createdAt;
    }
}
