package org.example.spartaschedule.dto;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {

    private String title;
    private String managerName;
    private String description;
    private String password;
}
