package org.example.spartaschedule.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.config.JwtUtil;
import org.example.spartaschedule.config.PasswordEncoder;
import org.example.spartaschedule.domain.auth.dto.SigninRequestDto;
import org.example.spartaschedule.domain.auth.dto.SigninResponseDto;
import org.example.spartaschedule.domain.auth.dto.SignupRequestDto;
import org.example.spartaschedule.domain.auth.dto.SignupResponseDto;
import org.example.spartaschedule.domain.auth.exception.AuthException;
import org.example.spartaschedule.domain.user.UserRole;
import org.example.spartaschedule.domain.user.entity.User;
import org.example.spartaschedule.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        if(userRepository.existsByEmail(signupRequestDto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        String encodePassword = passwordEncoder.encode(signupRequestDto.getPassword());

        UserRole userRole = convertToUserRole(signupRequestDto.getUserRole());

        User newUser = new User(
                signupRequestDto.getUserName(),
                signupRequestDto.getEmail(),
                encodePassword,
                userRole
        );

        User savedUser = userRepository.save(newUser);

        String bearerToken = jwtUtil.createToken(
                savedUser.getId(),
                savedUser.getUserName(),
                savedUser.getEmail(),
                userRole
        );

        return new SignupResponseDto(bearerToken);
    }

    public SigninResponseDto signin(SigninRequestDto signinRequestDto) {
        User user = userRepository.findByEmail(signinRequestDto.getEmail()).orElseThrow(
                ()-> new IllegalArgumentException("가입되지 않은 유저입니다."));

        if(!passwordEncoder.matches(signinRequestDto.getPassword(), user.getPassword())) {
            throw new AuthException("잘못된 비밀번호입니다.");
        }

        String bearerToken = jwtUtil.createToken(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                convertToUserRole(signinRequestDto.getUserRole())
        );

        return new SigninResponseDto(bearerToken);
    }

    private UserRole convertToUserRole(String userRoleString) {
        try {
            return UserRole.valueOf(userRoleString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 역할 정보입니다: " + userRoleString);
        }
    }
}
