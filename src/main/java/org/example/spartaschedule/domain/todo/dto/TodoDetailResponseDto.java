package org.example.spartaschedule.domain.todo.dto;

import lombok.Getter;
import org.example.spartaschedule.domain.user.dto.UserDto;

import java.time.LocalDateTime;

@Getter
public class TodoDetailResponseDto {

    private final Long id;
    private final String title;
    private final UserDto user;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String weather;

    public TodoDetailResponseDto(
            Long id,
            String title,
            UserDto user,
            int commentCount,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            String weather
    ) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.weather = weather;
    }
}
