package com.dev.dj.PlaceInTime.messages;

public enum UserMessages {
    
    NAME_NOT_BLANK("Name cannot be empty."),
    CPF_NOT_BLANK("CPF cannot be empty."),
    CPF_INVALID_SIZE("CPF must have exactly 11 digits."),
    EMAIL_NOT_BLANK("Email cannot be empty."),
    PASSWORD_NOT_BLANK("Password cannot be empty."),
    PHONE_NOT_BLANK("Phone cannot be empty."),
    PHONE_INVALID_SIZE("Phone must have exactly 11 digits."),
    ROLE_NOT_NULL("Role cannot be null.");

    private final String message;

    UserMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
