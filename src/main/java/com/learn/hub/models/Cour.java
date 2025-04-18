package com.learn.hub.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Entity
@Table(name = "Cour")
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Time duree;
    private String type;
    private String url;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToOne(mappedBy = "cour")
    private Inscriptions inscpriton;
}
