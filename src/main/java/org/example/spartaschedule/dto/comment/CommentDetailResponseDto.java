package org.example.spartaschedule.dto.comment;

import lombok.Getter;
import org.example.spartaschedule.dto.user.UserDto;

import java.time.LocalDateTime;

@Getter
public class CommentDetailResponseDto {

    private final Long id;
    private final UserDto user;
    private final String comment;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentDetailResponseDto(
            Long id,
            UserDto user,
            String comment,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.user = user;
        this.comment = comment;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
