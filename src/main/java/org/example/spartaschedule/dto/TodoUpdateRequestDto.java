package org.example.spartaschedule.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {

    private String title;
    private String managerName;
    private String description;
}
