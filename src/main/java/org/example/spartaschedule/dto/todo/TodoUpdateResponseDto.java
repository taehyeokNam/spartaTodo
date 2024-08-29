package org.example.spartaschedule.dto.todo;

import lombok.Getter;
import org.example.spartaschedule.dto.user.UserDto;

@Getter
public class TodoUpdateResponseDto {

    private final Long id;
    private final String title;
    private final UserDto user;
    private final String description;

    public TodoUpdateResponseDto (
            Long id,
            String title,
            UserDto user,
            String description
    ) {
        this.id = id;
        this.title =title;
        this.user = user;
        this.description = description;
    }
}
