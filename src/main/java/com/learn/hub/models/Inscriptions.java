package com.learn.hub.models;

import jakarta.persistence.*;

@Entity
@Table(name = "inscription")
public class Inscriptions {

    @EmbeddedId
    private InscriptionsId id;

    @ManyToOne
    @MapsId("UserId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("FormationId")
    @JoinColumn(name = "formation_id")
    private Formation formation;

    private int progress;

    @OneToOne
    @JoinColumn(name = "cour_id")
    private Cour cour;
}
