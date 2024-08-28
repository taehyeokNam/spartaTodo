package org.example.spartaschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSimpleResponseDto {

    private Long id;
    private String title;
    private String managerName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TodoSimpleResponseDto(
            Long id,
            String title,
            String managerName,
            String description,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.title = title;
        this.managerName = managerName;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}
