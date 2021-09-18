package com.mhp.coding.challenges.mapping.exceptions;

public class ArticleServiceException extends RuntimeException {

    private boolean status;
    private String message;

    public ArticleServiceException(){
        super();
    }

    public ArticleServiceException(String message){
        super(message);

        this.message = message;
        this.status = false;
    }
}
