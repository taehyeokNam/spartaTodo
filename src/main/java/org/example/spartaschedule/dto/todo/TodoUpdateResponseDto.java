package org.example.spartaschedule.dto.todo;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {

    private Long id;
    private String title;
    private String user;
    private String description;

    public TodoUpdateResponseDto (
            Long id,
            String title,
            String user,
            String description
    ) {
        this.id = id;
        this.title =title;
        this.user = user;
        this.description = description;
    }
}
