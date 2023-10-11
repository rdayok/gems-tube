package com.rdi.gemtube.exceptions;

public class GemTubeException extends Throwable {
    public GemTubeException(String message) {
        super(message);
    }

    public GemTubeException(Throwable throwable) {
        super(throwable);
    }
}
