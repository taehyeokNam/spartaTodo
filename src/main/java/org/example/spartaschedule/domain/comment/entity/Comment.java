package org.example.spartaschedule.domain.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.spartaschedule.domain.common.entity.Timestamped;
import org.example.spartaschedule.domain.todo.entity.Todo;
import org.example.spartaschedule.domain.user.entity.User;


@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    public Comment(User user, String comment, Todo todo) {
        this.user = user;
        this.comment = comment;
        this.todo = todo;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
