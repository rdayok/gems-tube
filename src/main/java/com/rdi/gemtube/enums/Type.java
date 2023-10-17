package com.rdi.gemtube.enums;

public enum Type {
    IMAGE("image"),
    VIDEO("video");

    private final String value;

    Type(String value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return value;
    }
}
