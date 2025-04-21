package com.learn.hub.customExceptions;

public class UserNotExistOrAuthenticatedException extends RuntimeException {
    public UserNotExistOrAuthenticatedException(String message) {
        super(message);
    }
}
