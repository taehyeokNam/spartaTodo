package org.example.spartaschedule.dto.todo;

import lombok.Getter;
import org.example.spartaschedule.dto.user.UserDto;
import org.example.spartaschedule.entity.User;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {

    private final Long id;
    private final String title;
    private final UserDto user;
    private final String description;
    private final LocalDateTime createdAt;

    public TodoSaveResponseDto(
            Long id,
            String title,
            UserDto user,
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
