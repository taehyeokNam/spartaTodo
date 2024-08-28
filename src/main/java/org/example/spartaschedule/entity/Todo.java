package org.example.spartaschedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String managerName;
    private String description;
    private String password;

    public Todo(String title, String managerName, String description, String password) {
        this.title = title;
        this.managerName = managerName;
        this.description = description;
        this.password = password;
    }

    public void update(String title, String managerName, String description) {
        this.title = title;
        this.managerName = managerName;
        this.description = description;
    }
}
