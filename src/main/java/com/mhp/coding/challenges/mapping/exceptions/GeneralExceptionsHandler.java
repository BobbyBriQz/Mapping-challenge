package com.mhp.coding.challenges.mapping.exceptions;

import com.mhp.coding.challenges.mapping.models.dto.APIError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionsHandler {

    @Value("${null.pointer.error.message:Oooops, Something Went Wrong!}")
    String nullErrorMessage;

    private Logger logger = LoggerFactory.getLogger(GeneralExceptionsHandler.class);


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIError> handleResourceNotFoundException(Exception ex) {
        APIError error = new APIError(ex.getMessage());
        logger.error("ResourceNotFoundException: {}", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArticleServiceException.class)
    public ResponseEntity<APIError> handleArticleServiceException(Exception ex) {
        APIError error = new APIError(ex.getMessage());
        logger.error("ArticleServiceException: {}", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIError> handleNullPointerException(Exception ex) {
        APIError error = new APIError(nullErrorMessage);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
