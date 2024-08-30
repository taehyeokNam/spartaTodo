package org.example.spartaschedule.domain.comment.dto;

import lombok.Getter;
import org.example.spartaschedule.domain.user.dto.UserDto;

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
