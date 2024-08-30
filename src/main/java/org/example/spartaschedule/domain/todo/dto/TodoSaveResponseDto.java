package org.example.spartaschedule.domain.todo.dto;

import lombok.Getter;
import org.example.spartaschedule.domain.user.dto.UserDto;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {

    private final Long id;
    private final String title;
    private final UserDto user;
    private final String description;
    private final LocalDateTime createdAt;
    private final String weather;

    public TodoSaveResponseDto(
            Long id,
            String title,
            UserDto user,
            String description,
            LocalDateTime createdAt,
            String weather
    ) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.description = description;
        this.createdAt = createdAt;
        this.weather = weather;
    }
}
