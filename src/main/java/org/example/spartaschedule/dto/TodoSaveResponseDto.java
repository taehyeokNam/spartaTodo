package org.example.spartaschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {

    private final Long id;
    private final String title;
    private final String managerName;
    private final String description;
    private final LocalDateTime createdAt;

    public TodoSaveResponseDto(
            Long id,
            String title,
            String managerName,
            String description,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.title = title;
        this.managerName = managerName;
        this.description = description;
        this.createdAt = createdAt;
    }
}
