package com.learn.hub.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "question")
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToOne(mappedBy = "question")
    private Reponse reponse;

}