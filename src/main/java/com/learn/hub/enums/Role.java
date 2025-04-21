package com.learn.hub.enums;

import lombok.Getter;

import java.util.Set;

@Getter
public enum Role {
    PROF(Set.of(
        Permissions.PROF_CREATE,
        Permissions.PROF_UPDATE,
        Permissions.PROF_DELETE,
        Permissions.PROF_READ
    )),
    STUDENT(Set.of(
        Permissions.STUDENT_CREATE,
        Permissions.STUDENT_UPDATE,
        Permissions.STUDENT_DELETE,
        Permissions.STUDENT_READ
    ));

    private final Set<Permissions> permissions;

    Role(Set permissions) {
        this.permissions = permissions;
    }

    public String getRoleName() {
        return "ROLE_"+this.name();
    }
}
