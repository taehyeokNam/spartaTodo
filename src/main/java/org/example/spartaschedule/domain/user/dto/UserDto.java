package org.example.spartaschedule.domain.user.dto;

import lombok.Getter;

@Getter
public class UserDto {

    private final Long id;
    private final String userName;
    private final String email;

    public UserDto(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
