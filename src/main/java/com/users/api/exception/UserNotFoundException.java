package com.users.api.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String id) {
        super("User not found: " + id);
    } 
}
