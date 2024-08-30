package org.example.spartaschedule.domain.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.spartaschedule.domain.comment.entity.Comment;
import org.example.spartaschedule.domain.common.entity.Timestamped;
import org.example.spartaschedule.domain.user.entity.User;

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
    private String description;
    private String weather;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Todo(String title, User user, String description, String weather) {
        this.title = title;
        this.user = user;
        this.description = description;
        this.weather = weather;
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
