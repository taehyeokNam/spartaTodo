package org.example.spartaschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoDetailResponseDto {

    private final Long id;
    private final String title;
    private final String managerName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoDetailResponseDto(
            Long id,
            String title,
            String managerName,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.title = title;
        this.managerName = managerName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
