package com.learn.hub.enums;

import lombok.Getter;

import java.util.Set;

@Getter
public enum Role {
    PROF(Set.of(
        Permissions.CREATE_BADGE,
        Permissions.READ_BADGE,
        Permissions.UPDATE_BADGE,
        Permissions.DELETE_BADGE,
        Permissions.CREATE_COUR,
        Permissions.READ_COUR,
        Permissions.UPDATE_COUR,
        Permissions.DELETE_COUR,
        Permissions.CREATE_FROMATION,
        Permissions.READ_FROMATION,
        Permissions.UPDATE_FROMATION,
        Permissions.DELETE_FROMATION,
        Permissions.CREATE_QUESTION,
        Permissions.READ_QUESTION,
        Permissions.UPDATE_QUESTION,
        Permissions.DELETE_QUESTION,
        Permissions.CREATE_QUIZ,
        Permissions.READ_QUIZ,
        Permissions.UPDATE_QUIZ,
        Permissions.DELETE_QUIZ,
        Permissions.CREATE_RESPONSE,
        Permissions.READ_RESPONSE,
        Permissions.UPDATE_RESPONSE,
        Permissions.DELETE_RESPONSE
    )),
    STUDENT(Set.of(
        Permissions.READ_BADGE,
        Permissions.READ_COUR,
        Permissions.READ_FROMATION,
        Permissions.READ_QUESTION,
        Permissions.READ_QUIZ,
        Permissions.READ_RESPONSE
    ));

    private final Set<Permissions> permissions;

    Role(Set permissions) {
        this.permissions = permissions;
    }
}
