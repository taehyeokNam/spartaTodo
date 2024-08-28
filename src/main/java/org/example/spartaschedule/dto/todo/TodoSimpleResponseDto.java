package org.example.spartaschedule.dto.todo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSimpleResponseDto {

    private Long id;
    private String title;
    private String user;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TodoSimpleResponseDto(
            Long id,
            String title,
            String user,
            String description,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
