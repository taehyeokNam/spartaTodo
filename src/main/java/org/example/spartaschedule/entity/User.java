package org.example.spartaschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Manager> managers = new ArrayList<>();

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

}
