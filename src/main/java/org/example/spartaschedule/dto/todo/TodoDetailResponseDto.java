package org.example.spartaschedule.dto.todo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoDetailResponseDto {

    private final Long id;
    private final String title;
    private final String user;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoDetailResponseDto(
            Long id,
            String title,
            String user,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
