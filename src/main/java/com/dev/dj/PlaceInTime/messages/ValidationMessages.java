package com.dev.dj.PlaceInTime.messages;

public enum ValidationMessages {
    
    INVALID_REQUEST_BODY("Body da requisição está inválido."),
    VALIDATION_ERROR("Erro de validação.");

    private final String message;

    ValidationMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
