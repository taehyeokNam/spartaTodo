package org.example.spartaschedule.domain.todo.dto;

import lombok.Getter;
import org.example.spartaschedule.domain.user.dto.UserDto;

@Getter
public class TodoUpdateResponseDto {

    private final Long id;
    private final String title;
    private final UserDto user;
    private final String description;
    private final String weather;

    public TodoUpdateResponseDto (
            Long id,
            String title,
            UserDto user,
            String description,
            String weather
    ) {
        this.id = id;
        this.title =title;
        this.user = user;
        this.description = description;
        this.weather = weather;
    }
}
