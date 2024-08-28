package org.example.spartaschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(String user, String comment, Todo todo) {
        this.user = user;
        this.comment = comment;
        this.todo = todo;
    }

    public void update(String user, String comment) {
        this.user = user;
        this.comment = comment;
    }
}
