package org.example.spartaschedule.domain.manager.dto;

import lombok.Getter;
import org.example.spartaschedule.domain.user.dto.UserDto;

@Getter
public class ManagerDetailResponseDto {

    private final Long id;
    private final UserDto user;

    public ManagerDetailResponseDto(Long id, UserDto user) {
        this.id = id;
        this.user = user;
    }
}
