package org.example.spartaschedule.domain.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDetailResponseDto {

    private final Long id;
    private final String userName;
    private final String email;
    private final LocalDateTime createdAt;

    public UserDetailResponseDto(Long id, String userName, String email, LocalDateTime createdAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
    }
}
