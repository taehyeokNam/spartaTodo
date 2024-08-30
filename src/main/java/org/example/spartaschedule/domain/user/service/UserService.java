package org.example.spartaschedule.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.config.JwtUtil;
import org.example.spartaschedule.config.PasswordEncoder;
import org.example.spartaschedule.domain.user.dto.UserDetailResponseDto;
import org.example.spartaschedule.domain.user.dto.UserSaveRequestDto;
import org.example.spartaschedule.domain.user.dto.UserSaveResponseDto;
import org.example.spartaschedule.domain.user.dto.UserSimpleResponseDto;
import org.example.spartaschedule.domain.user.entity.User;
import org.example.spartaschedule.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class UserService {

    private final UserRepository userRepository;

    public List<UserSimpleResponseDto> getUsers() {

        List<User> userList = userRepository.findAll();
        List<UserSimpleResponseDto> dtoList = new ArrayList<>();

        for (User user : userList) {
            UserSimpleResponseDto dto = new UserSimpleResponseDto(
                    user.getId(),
                    user.getUserName(),
                    user.getEmail(),
                    user.getCreatedAt()
            );
            dtoList.add(dto);
        }

        return dtoList;
    }

    public UserDetailResponseDto getUser(Long userId) {

        User user = findUserById(userId);

        return new UserDetailResponseDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

    @Transactional
    public void deleteUser(Long userId) {

        if(findUserById(userId) != null) {
            userRepository.deleteById(userId);
        }
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));
    }
}
