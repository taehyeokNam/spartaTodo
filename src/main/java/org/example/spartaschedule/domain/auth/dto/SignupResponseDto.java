package org.example.spartaschedule.domain.auth.dto;

import lombok.Getter;
import org.example.spartaschedule.domain.user.dto.UserSaveResponseDto;

@Getter
public class SignupResponseDto {

    private final String bearerToken;

    public SignupResponseDto(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
