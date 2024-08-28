package org.example.spartaschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
