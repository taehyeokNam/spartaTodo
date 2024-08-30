package org.example.spartaschedule.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.domain.auth.dto.SigninRequestDto;
import org.example.spartaschedule.domain.auth.dto.SigninResponseDto;
import org.example.spartaschedule.domain.auth.dto.SignupRequestDto;
import org.example.spartaschedule.domain.auth.dto.SignupResponseDto;
import org.example.spartaschedule.domain.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public SignupResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        return authService.signup(signupRequestDto);
    }

    @PostMapping("/auth/signin")
    public SigninResponseDto signin(@RequestBody SigninRequestDto signinRequestDto) {
        return authService.signin(signinRequestDto);
    }
}
