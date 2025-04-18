package com.learn.hub.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class InscriptionsId {

    private Long UserId;
    private Long FormationId;

}
