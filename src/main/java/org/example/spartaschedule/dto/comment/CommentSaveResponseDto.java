package org.example.spartaschedule.dto.comment;

import lombok.Getter;
import org.example.spartaschedule.dto.user.UserDto;

import java.time.LocalDateTime;

@Getter
public class CommentSaveResponseDto {

    private final Long id;
    private final String comment;
    private final LocalDateTime createdAt;
    private final UserDto user;

    public CommentSaveResponseDto(
            Long id,
            String comment,
            LocalDateTime createdAt,
            UserDto user) {

        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
        this.user = user;
    }
}
