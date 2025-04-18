package com.learn.hub.enums;

import lombok.Getter;

@Getter
public enum QuestionTypes {
    MUTLI_SELECT("multiselect"),
    SELECT("select");

    private final String type;

    QuestionTypes(String type) {
        this.type = type;
    }
}
