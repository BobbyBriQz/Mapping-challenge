package com.mhp.coding.challenges.mapping.exceptions;

public class ResourceNotFoundException extends ArticleServiceException {

    private boolean status;
    private String message;

    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);

        this.message = message;
        this.status = false;
    }
}
