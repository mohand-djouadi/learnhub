package com.learn.hub.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum Permissions {

    PROF_READ("prof:read"),
    PROF_CREATE("prof:create"),
    PROF_UPDATE("prof:update"),
    PROF_DELETE("prof:delete"),
    STUDENT_READ("student:read"),
    STUDENT_CREATE("student:create"),
    STUDENT_UPDATE("student:update"),
    STUDENT_DELETE("student:delete");

    private final String permissionVal;

    Permissions(String val) {
        this.permissionVal = val;
    }

}
