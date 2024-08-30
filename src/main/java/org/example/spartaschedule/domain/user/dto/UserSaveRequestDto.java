package org.example.spartaschedule.domain.user.dto;

import lombok.Getter;

@Getter
public class UserSaveRequestDto {

    private String userName;
    private String email;
    private String password;
}
