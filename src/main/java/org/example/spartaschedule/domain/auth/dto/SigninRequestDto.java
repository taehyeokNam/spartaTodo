package org.example.spartaschedule.domain.auth.dto;

import lombok.Getter;

@Getter
public class SigninRequestDto {

    private String email;
    private String password;
    private String userRole;
}
