package org.example.spartaschedule.dto.manager;

import lombok.Getter;
import org.example.spartaschedule.dto.user.UserDto;

@Getter
public class ManagerDetailResponseDto {

    private final Long id;
    private final UserDto user;

    public ManagerDetailResponseDto(Long id, UserDto user) {
        this.id = id;
        this.user = user;
    }
}
