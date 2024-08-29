package org.example.spartaschedule.dto.todo;

import lombok.Getter;
import org.example.spartaschedule.dto.user.UserDto;
import org.example.spartaschedule.entity.User;

import java.time.LocalDateTime;

@Getter
public class TodoSimpleResponseDto {

    private final Long id;
    private final String title;
    private final UserDto user;
    private final String description;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoSimpleResponseDto(
            Long id,
            String title,
            UserDto user,
            String description,
            int commentCount,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.description = description;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
