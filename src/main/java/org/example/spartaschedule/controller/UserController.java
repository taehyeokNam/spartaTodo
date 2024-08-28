package org.example.spartaschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaschedule.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}
