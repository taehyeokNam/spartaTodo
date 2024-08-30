package org.example.spartaschedule.domain.auth.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {

    private String userName;
    private String email;
    private String password;
    private String userRole;
}
