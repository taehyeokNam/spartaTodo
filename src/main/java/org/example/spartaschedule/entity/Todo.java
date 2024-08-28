package org.example.spartaschedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String managerName;
    private String description;
    private String passwrod;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Todo(String title, String managerName, String description) {
        this.title = title;
        this.managerName = managerName;
        this.description = description;
    }

}
