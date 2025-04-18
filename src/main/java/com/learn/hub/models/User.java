package com.learn.hub.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
        name = "student_badge",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "badge_id")
    )
    private List<Badge> badges;

    @OneToMany(mappedBy = "user")
    private List<Inscriptions> inscriptions;

    @OneToMany(mappedBy = "prof")
    private List<Formation> formations;

}
