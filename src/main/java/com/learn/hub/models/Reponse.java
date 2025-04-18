package com.learn.hub.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "response")
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Boolean istrue;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
