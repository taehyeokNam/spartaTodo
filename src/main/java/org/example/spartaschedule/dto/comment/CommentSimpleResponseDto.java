package org.example.spartaschedule.dto.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSimpleResponseDto {

    private final Long id;
    private final String user;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentSimpleResponseDto(
            Long id,
            String user,
            String contents,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt)
    {
        this.id = id;
        this.user = user;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
