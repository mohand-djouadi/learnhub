package com.learn.hub.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Badge")
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int points;

    @OneToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @ManyToMany(mappedBy = "badges")
    private List<User> users;

}
