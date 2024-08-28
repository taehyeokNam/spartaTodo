package org.example.spartaschedule.dto;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {

    private Long id;
    private String title;
    private String managerName;
    private String description;

    public TodoUpdateResponseDto (
            Long id,
            String title,
            String managerName,
            String description
    ) {
        this.id = id;
        this.title =title;
        this.managerName = managerName;
        this.description = description;
    }
}
