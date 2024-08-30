package org.example.spartaschedule.domain.todo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSimpleResponseDto {

    private final Long id;
    private final String title;
    private final String description;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String weather;

    public TodoSimpleResponseDto(
            Long id,
            String title,
            String description,
            int commentCount,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            String weather
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.weather = weather;
    }

}
