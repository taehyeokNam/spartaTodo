package org.example.spartaschedule.dto.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveResponseDto {

    private final Long id;
    private final String user;
    private final String comment;
    private final LocalDateTime createdAt;

    public CommentSaveResponseDto(
            Long id,
            String user,
            String comment,
            LocalDateTime createdAt) {

        this.id = id;
        this.user = user;
        this.comment = comment;
        this.createdAt = createdAt;
    }
}
