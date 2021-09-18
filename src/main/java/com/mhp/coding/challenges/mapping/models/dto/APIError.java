package com.mhp.coding.challenges.mapping.models.dto;

public class APIError {

    private boolean status;
    private String message;

    public APIError(String message){
        this.message = message;
        this.status = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
