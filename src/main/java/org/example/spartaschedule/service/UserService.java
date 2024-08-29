package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.dto.user.UserDetailResponseDto;
import org.example.spartaschedule.dto.user.UserSaveRequestDto;
import org.example.spartaschedule.dto.user.UserSaveResponseDto;
import org.example.spartaschedule.dto.user.UserSimpleResponseDto;
import org.example.spartaschedule.entity.User;
import org.example.spartaschedule.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveRequestDto) {

        if(userRepository.existsByEmail(userSaveRequestDto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User newUser = new User(
                userSaveRequestDto.getUserName(),
                userSaveRequestDto.getEmail()
        );

        User savedUser = userRepository.save(newUser);

        return new UserSaveResponseDto(
                savedUser.getId(),
                savedUser.getUserName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt()
        );
    }

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
