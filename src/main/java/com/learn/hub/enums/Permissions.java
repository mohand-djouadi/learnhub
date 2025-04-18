package com.learn.hub.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum Permissions {

    // badge object permissions
    CREATE_BADGE("create:badge"),
    READ_BADGE("read:badge"),
    UPDATE_BADGE("update:badge"),
    DELETE_BADGE("delete:badge"),
    // cour object permissions
    CREATE_COUR("create:cour"),
    READ_COUR("read:cour"),
    UPDATE_COUR("update:cour"),
    DELETE_COUR("delete:cour"),
    // formation object permissions
    CREATE_FROMATION("create:formation"),
    READ_FROMATION("read:formation"),
    UPDATE_FROMATION("update:formation"),
    DELETE_FROMATION("delete:formation"),
    // question object permissions
    CREATE_QUESTION("create:question"),
    READ_QUESTION("read:question"),
    UPDATE_QUESTION("update:question"),
    DELETE_QUESTION("delete:question"),
    // quiz object permissions
    CREATE_QUIZ("create:quiz"),
    READ_QUIZ("read:quiz"),
    UPDATE_QUIZ("update:quiz"),
    DELETE_QUIZ("delete:quiz"),
    // response object permissions
    CREATE_RESPONSE("create:response"),
    READ_RESPONSE("read:response"),
    UPDATE_RESPONSE("update:response"),
    DELETE_RESPONSE("delete:response");

    private final String permissionVal;

    Permissions(String val) {
        this.permissionVal = val;
    }

}
