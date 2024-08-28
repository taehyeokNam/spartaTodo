package org.example.spartaschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String user;
    private String description;
    private String password;

    @OneToMany(mappedBy = "todo")
    private List<Comment> comments = new ArrayList<>();

    public Todo(String title, String user, String description, String password) {
        this.title = title;
        this.user = user;
        this.description = description;
        this.password = password;
    }

    public void update(String title, String user, String description) {
        this.title = title;
        this.user = user;
        this.description = description;
    }
}
